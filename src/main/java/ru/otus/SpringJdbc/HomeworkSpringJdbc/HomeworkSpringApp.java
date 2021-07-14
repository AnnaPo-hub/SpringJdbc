package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.AuthorService;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.CommentService;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.GenreService;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.LibraryService;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkSpringApp {

    public static void main(String[] args) throws SQLException {

        final ConfigurableApplicationContext context = SpringApplication.run(HomeworkSpringApp.class, args);
        final CommentService commentsService = context.getBean(CommentService.class);
        final AuthorService authorService = context.getBean(AuthorService.class);
        final GenreService genreService = context.getBean(GenreService.class);
        LibraryService service = context.getBean(LibraryService.class);

       // authorService.insert(new Author((long) 1, "Pushkin"));
       // genreService.insert(new Genre((long) 1, "Poetry"));

//
//      Genre testGenre = new Genre((long) 1, "Non-fiction");
        Genre testGenre2 = new Genre((long) 1, "Poetry");
//     Author testAuthor = new Author((long) 1, "William Nilson");
//        Author testAuthor2 = new Author((long) 2, "Claus Annik");
//        List<Comment> commentList = new ArrayList<>();
//        commentList.add(new Comment((long) 1, LocalDate.now(), "Good Book", "Anna", new Book((long) 1, "Woo", testAuthor, testGenre, commentList)));
////

//        System.out.println("---------");
      //  service.createBook(new Book((long) 1, "Nature", new Author((long) 1, "Pushkin"), testGenre2, null));

        //  service.createBook(new Book((long) 2, "Woobe", testAuthor2, testGenre, null));
//        System.out.println("---------");
//        final Optional<Book> bookById = service.findBookById((long) 1);
//        System.out.println("найти книгу по айди " + bookById);
//       // service.deleteBookById((long) 1);
////        final List<Book> bookById2 = service.findBookByAuthor("William Nilson");
////        System.out.println("найти книгу по автору " + bookById2);
//        final List<Book> bookById4 = service.findBookByGenre("Non-fiction");
//        System.out.println("найти книгу по жанру " + bookById4);
//        System.out.println("_______________" );
//        final Comment commentByBookId = commentsService.getCommentByBookId((long) 1);
//        System.out.println(" коммент по бук ай ди" + commentByBookId);
//
//       commentsService.deleteCommentByBookId((long)1);
       // commentsService.insertComment(new Comment((long) 1, LocalDate.now(), "Uf, Good Book", "Petr", new Book((long) 1, "Nature", new Author((long) 1, "Pushkin"), testGenre2, null)));

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
