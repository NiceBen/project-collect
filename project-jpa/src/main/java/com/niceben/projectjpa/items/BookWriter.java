package com.niceben.projectjpa.items;

import com.niceben.projectjpa.model.entity.Book;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.batch.item.ItemWriter;

import java.util.Arrays;
import java.util.List;

/**
 * 下面详细解释BookWriter类，其针对每条书籍信息创建一行，属性作为列进行存储。
 */
public class BookWriter implements ItemWriter<Book> {
    private final Sheet sheet;

    public BookWriter(Sheet sheet) {
        this.sheet = sheet;
    }

    /**
     * 定义写的方法
     * @param list items to be written
     * @throws Exception
     */
    @Override
    public void write(List<? extends Book> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            writeRow(i + 1, list.get(i));
        }
    }

    /**
     * 定义每行
     * @param currentRowNumber
     * @param book
     */
    private void writeRow(int currentRowNumber, Book book) {
        List<String> columns = prepareColumns(book);
        Row row = this.sheet.createRow(currentRowNumber);
        for (int i = 0; i < columns.size(); i++) {
            writeCell(row, i, columns.get(i));
        }
    }

    /**
     * 获取一行填充的数据
     * @param book
     * @return
     */
    private List<String> prepareColumns(Book book) {
        return Arrays.asList(
                book.getId().toString(),
                book.getAuthor(),
                book.getTitle(),
                book.getIsBn()
        );
    }

    /**
     * 填充单元格
     * @param row
     * @param currentColumnNumber
     * @param value
     */
    private void writeCell(Row row, int currentColumnNumber, String value) {
        Cell cell = row.createCell(currentColumnNumber);
        cell.setCellValue(value);
    }
}
