package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.LibraryService;

import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class HomeworkSpringJdbcApplication {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = SpringApplication.run(HomeworkSpringJdbcApplication.class, args);
        LibraryService service = context.getBean(LibraryService.class);


       // service.insertBook(new BookBo(2, "Bluck", "The Wind", "poetry"));
        final List<Book> all = service.showAllBooks();
        System.out.println("все книги в библиотеке: " + all.size());

       // service.createBook(new Book(3, "Bluck", "The Wind", "poetry"));
//        final List<Book> all2 = service.showAllBooks();
//        System.out.println("все книги в библиотеке: " + all2.size());

        Console.main(args);

    }
}
