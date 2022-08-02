package com.niceben.projectjpa.config;

import com.niceben.projectjpa.items.BookWriter;
import com.niceben.projectjpa.listener.BookJobListener;
import com.niceben.projectjpa.mapper.BookRepository;
import com.niceben.projectjpa.model.entity.Book;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import javax.batch.api.listener.JobListener;
import java.util.Collections;

@EnableBatchProcessing
@Configuration
public class BatchJobConfig {

    private static final Integer CHUNK = 100;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    public BatchJobConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    /**
     * 创建任务
     */
    @Bean
    public Job job(Step step, JobExecutionListener listener) {
        return jobBuilderFactory.get("exportBooksToXlsx")
                .start(step)
                .listener(listener)
                .build();
    }

    /**
     * 创建步骤
     */
    @Bean
    public Step step(ItemReader<Book> reader, ItemWriter<Book> writer) {
        return stepBuilderFactory.get("export")
                .<Book, Book>chunk(CHUNK)
                .reader(reader)
                .writer(writer)
                .build();
    }


    /**
     * 下面创建 RepositoryItemReader 从 JPA 读取数据，并启用JPA repository。在配置类中定义读步骤
     */
    @Bean
    public ItemReader<Book> bookItemReader(BookRepository repository) {
        RepositoryItemReader<Book> reader = new RepositoryItemReader<>();
        reader.setRepository(repository);
        reader.setMethodName("findAll");
        reader.setPageSize(CHUNK);
        reader.setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        return reader;
    }

    /**
     * SXSSFWorkbook 在内存中的数量有CHUNK静态常量定义。使用workbook定义sheet，我们先声明BookWriter，后面详细解释
     */
    @Bean
    public ItemWriter<Book> bookItemWriter(SXSSFWorkbook workbook) {
        SXSSFSheet sheet = workbook.createSheet("Books");
        return new BookWriter(sheet);
    }

    @Bean
    public BookJobListener jobListener(SXSSFWorkbook workbook, BookRepository bookRepository) {
        return new BookJobListener(workbook, bookRepository);
    }

    /**
     * 读取书籍信息是为了写Excel，所有信息都保存在Workbook，我们定义一个Bean
     */
    @Bean
    public SXSSFWorkbook workbook() {
        return new SXSSFWorkbook(CHUNK);
    }

}
