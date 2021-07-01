package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkSpringJdbcApplication {

    public static void main(String[] args) throws SQLException {

        ApplicationContext context = SpringApplication.run(HomeworkSpringJdbcApplication.class, args);
  //      LibraryService service = context.getBean(LibraryService.class);
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

        // Console.main(args);

    }
}
