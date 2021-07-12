package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkSpringApp {

    public static void main(String[] args) throws SQLException {

        final ConfigurableApplicationContext context = SpringApplication.run(HomeworkSpringApp.class, args);
//        Genre testGenre = new Genre((long)2, "Non-fiction");
//        Author testAuthor = new Author((long)2, "William Nilson");
//
//        LibraryService service = context.getBean(LibraryService.class);
//        service.createBook(new Book((long)4, "Woo",testAuthor, testGenre));
//        service.createBook(new Book((long)5, "Woobe",testAuthor, testGenre));
//        final Book bookById = service.findBookById((long) 10);
//        System.out.println(bookById);


        //service.deleteBookById(1);
        //   final List<Book> all = service.findBookByName("the wind");
        //  System.out.println("все книги в библиотеке: " + all.size());

//        service.createBook(new Book((long) 3, "The nature", new Author((long) 1, "Block"), new Genre((long) 1, "Poetry")));
//        final List<Book> books = service.showAllBooks();
//        System.out.println(books.size());


//        final List<Book> block = service.findBookByGenre("Poetry");
//        System.out.println(block.size());

        // service.createBook(new Book(3, "Bluck", "The Wind", "poetry"));
//        final List<Book> all2 = service.showAllBooks();
//        System.out.println("все книги в библиотеке: " + all2.size());

        Console.main(args);

    }
}
