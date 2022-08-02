package com.niceben.projectjpa.listener;

import com.niceben.projectjpa.mapper.BookRepository;
import com.niceben.projectjpa.model.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.item.ExecutionContext;

import javax.batch.runtime.BatchStatus;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Slf4j
public class BookJobListener implements JobExecutionListener {

    private final SXSSFWorkbook workbook;
    private final BookRepository bookRepository;

    public BookJobListener(SXSSFWorkbook workbook, BookRepository bookRepository) {
        this.workbook = workbook;
        this.bookRepository = bookRepository;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        initializeBooks(bookRepository);

        ExecutionContext context = jobExecution.getExecutionContext();
        context.put("titles", Arrays.asList("id", "title", "author", "isBn"));
        context.put("resourceName", "e://tmp/书籍信息");

        headRow((List<String>) Objects.requireNonNull(context.get("titles")));
    }


    @Override
    public void afterJob(JobExecution jobExecution) {
        BatchStatus batchStatus = jobExecution.getStatus().getBatchStatus();
        String resName = (String) jobExecution.getExecutionContext().get("resourceName");
        assert resName != null;

        if (batchStatus == BatchStatus.COMPLETED) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(resName + ".xlsx");
                workbook.write(fileOutputStream);
                fileOutputStream.close();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
    }


    private void initializeBooks(BookRepository bookRepository) {
        Set<Book> books = new HashSet<>();
        Book.BookBuilder builder = Book.builder();
        books.add(builder.author("John Doe").title("Forbid tails").isBn("1111-111-111-111").build());
        books.add(builder.author("Mary Doe").title("Not found title").isBn("2222-222-222-222").build());
        bookRepository.saveAll(books);
    }


    private void headRow(List<String> titles) {
        Row row = workbook.getSheetAt(0).createRow(0);
        for (int i = 0; i < titles.size(); i++) {
            writeCell(row, i, titles.get(i));
        }
    }

    private void writeCell(Row row, int currentColumnNumber, String value) {
        Cell cell = row.createCell(currentColumnNumber);
        cell.setCellValue(value);
    }
}
