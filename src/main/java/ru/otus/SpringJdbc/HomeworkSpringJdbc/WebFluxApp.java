package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookRepository;

import java.util.Arrays;


@SpringBootApplication
public class WebFluxApp {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(WebFluxApp.class);
        BookRepository bookRepository = context.getBean(BookRepository.class);

        Book testBook = new  Book();
        testBook.setAuthor("Anna");
        testBook.setName("The Ladoga");
        testBook.setGenre("Adventure");
        testBook.setId("3");


        bookRepository.saveAll(Arrays.asList(
                new Book("1", "The sun", "Vilkov", "Poetry"),
                new Book("2", "The wind", "Lozhkin", "Fiction"),
                testBook

        )).subscribe(p -> System.out.println(p.getName()));

       bookRepository.save(testBook).subscribe(p-> System.out.println(p.getGenre()));
    }
}

