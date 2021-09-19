package ru.otus.SpringJdbc.HomeworkSpringJdbc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.lang.NonNull;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoBook;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.TransformBookService;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {
    private static final int CHUNK_SIZE = 2;
    private final Logger logger = LoggerFactory.getLogger("Batch");

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    @StepScope
    @Bean
    public JpaPagingItemReader<Book> reader() {
        return new JpaPagingItemReaderBuilder<Book>().name("jpaPagingItemReader")
                .entityManagerFactory(entityManagerFactory)
                .pageSize(CHUNK_SIZE)
                .queryString("select b from Book b ")
                .build();
    }

    @StepScope
    @Bean
    public ItemProcessor<Book, MongoBook> processor(TransformBookService transformBookService) {
        return transformBookService::makeMangoBookFromJpaBook;
    }

    @StepScope
    @Bean
    public MongoItemWriter<MongoBook> writer() {
        return new MongoItemWriterBuilder<MongoBook>()
                .template(mongoTemplate)
                .collection("book")
                .build();
    }


    @Bean
    public Job bookJob(Step transformBookStep) {
        return jobBuilderFactory.get("bookJob")
                .incrementer(new RunIdIncrementer())
                .flow(transformBookStep)
                .end()
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(@NonNull JobExecution jobExecution) {
                        logger.info("Начало job");
                    }

                    @Override
                    public void afterJob(@NonNull JobExecution jobExecution) {
                        logger.info("Конец job");
                    }
                })
                .build();
    }

    @Bean
    public Step transformBookStep(ItemReader<Book> reader, ItemWriter<MongoBook> writer,
                                  ItemProcessor <Book, MongoBook> itemProcessor) {
        return stepBuilderFactory.get("transformBookStep")
                .<Book, Book>chunk(CHUNK_SIZE)
                .reader(reader)
                .processor(itemProcessor)
                .writer(writer)
                .listener(new ItemReadListener<>() {
                    public void beforeRead() {
                        logger.info("Начало чтения");
                    }

                    public void afterRead(@NonNull Book o) {
                        logger.info("Конец чтения");
                    }

                    public void onReadError(@NonNull Exception e) {
                        logger.info("Ошибка чтения");
                    }
                })
                .listener(new ItemWriteListener<>() {
                    public void beforeWrite(@NonNull List list) {
                        logger.info("Начало записи");
                    }

                    public void afterWrite(@NonNull List list) {
                        logger.info("Конец записи");
                    }

                    public void onWriteError(@NonNull Exception e, @NonNull List list) {
                        logger.info("Ошибка записи");
                    }
                })
                .listener(new ItemProcessListener<>() {
                    public void beforeProcess(Book o) {
                        logger.info("Начало обработки");
                    }

                    public void afterProcess(@NonNull Book o, Book o2) {
                        logger.info("Конец обработки");
                    }

                    public void onProcessError(@NonNull Book o, @NonNull Exception e) {
                        logger.info("Ошибка обработки");
                    }
                })
                .listener(new ChunkListener() {
                    public void beforeChunk(@NonNull ChunkContext chunkContext) {
                        logger.info("Начало пачки");
                    }

                    public void afterChunk(@NonNull ChunkContext chunkContext) {
                        logger.info("Конец пачки");
                    }

                    public void afterChunkError(@NonNull ChunkContext chunkContext) {
                        logger.info("Ошибка пачки");
                    }
                })
                .build();
    }
}
