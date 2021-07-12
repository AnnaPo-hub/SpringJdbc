package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.LibraryService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class HomeworkSpringApp {

    public static void main(String[] args) throws SQLException {

        final ConfigurableApplicationContext context = SpringApplication.run(HomeworkSpringApp.class, args);
        Genre testGenre = new Genre((long) 1, "Non-fiction");
        Genre testGenre2 = new Genre((long) 2, "Poetry");
        Author testAuthor = new Author((long) 2, "William Nilson");
        Author testAuthor2 = new Author((long) 3, "Claus Annik");
        List<Comment> commentList = new ArrayList<>();

        LibraryService service = context.getBean(LibraryService.class);
        System.out.println("---------");
        service.createBook(new Book((long) 1, "Woo", testAuthor, testGenre, null));
        service.createBook(new Book((long) 2, "Woobe", testAuthor2, testGenre, null));
        System.out.println("---------");
        final Optional<Book> bookById = service.findBookById((long) 1);
        System.out.println("найти книгу по айди " + bookById);
       // service.deleteBookById((long) 1);
//        final List<Book> bookById2 = service.findBookByAuthor("William Nilson");
//        System.out.println("найти книгу по автору " + bookById2);
        final List<Book> bookById4 = service.findBookByGenre("Non-fiction");
        System.out.println("найти книгу по жанру " + bookById4);
       // final List<Book> bookById3 = service.findBookByName("Woobe");
        //System.out.println("найти книгу по названию " + bookById3);
     //   System.out.println(service.showAllBooks());

//        System.out.println("---------");
//        System.out.println(bookById);
//
//
//       // service.deleteBookById((long)1);
//           final Optional<Book> all = service.findBookByName("the wind");
//      //    System.out.println("все книги в библиотеке: " + all.size());
//
//       // service.createBook(new Book((long) 3, "The nature", new Author((long) 1, "Block"), new Genre((long) 1, "Poetry"),commentList));
//        final List<Book> books = service.showAllBooks();
//        System.out.println(books.size());
//
//
//        final Optional<Book> block = service.findBookByGenre("Poetry");
//      //  System.out.println(block.size());
//
//      //   service.createBook(new Book((long)3, "Bluck", "The Wind", "poetry",commentList));
//        final List<Book> all2 = service.showAllBooks();
//        System.out.println("все книги в библиотеке: " + all2.size());

        Console.main(args);

    }
}
