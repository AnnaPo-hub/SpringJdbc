package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookRepository;

import java.util.Arrays;


@SpringBootApplication
public class WebFluxApp {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(WebFluxApp.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        bookRepository.saveAll(Arrays.asList(
                new Book((long) 1, "The sun", new Author("Vilkov"), "Poetry"),
                new Book((long) 2, "The wind", new Author("Lozhkin"), "Fiction")
        )).subscribe(p -> System.out.println(p.getName()));
    }
}

