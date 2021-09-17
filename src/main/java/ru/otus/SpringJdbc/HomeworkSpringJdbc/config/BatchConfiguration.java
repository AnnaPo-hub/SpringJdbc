package ru.otus.SpringJdbc.HomeworkSpringJdbc.config;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.MongoItemWriter;
import org.springframework.batch.item.data.builder.MongoItemWriterBuilder;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public ItemReader<Book> reader() throws Exception {
        String jpqlQuery = "select b from Book b ";

        JpaPagingItemReader<Book> reader = new JpaPagingItemReader<Book>();
        reader.setQueryString(jpqlQuery);
      //  reader.setEntityManagerFactory();
        reader.setPageSize(3);
        reader.afterPropertiesSet();
        reader.setSaveState(true);

        return reader;
    }

    @Bean
    public MongoItemWriter<Book> writer (MongoTemplate mongoTemplate){
        return new MongoItemWriterBuilder<Book>().template(mongoTemplate).collection("book").build();
    }

//    @Bean
//    public BookItemProcessor processor(){
//        return new BookItemProcessor();
//    }
}
