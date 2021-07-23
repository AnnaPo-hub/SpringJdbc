package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.AuthorService;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.BookService;

import java.util.List;

@EnableMongoRepositories
@SpringBootApplication
public class HomeworkSpringApp {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(HomeworkSpringApp.class, args);
        final AuthorService authorService = run.getBean(AuthorService.class);


        //final Author pushkin = authorService.insert(new Author((long) 1, "Pushkin", null));
       // System.out.println("добавила аутхора" + pushkin);

        //final Author prust = authorService.insert(new Author((long) 2, "Prust", null));
        // System.out.println("добавила аутхора Пруста " + prust);

//        final List<Author> pushkin1 = authorService.getByName("Pushkin");
//        System.out.println("нашла аутхора Пушкина " + pushkin1);
//
//        final Optional<Author> authorById = authorService.getById((long) 2);
//        System.out.println("нашла аутхора Пруста по id " + authorById);
//
//        authorService.deleteById((long)1);
//
//        final List<Author> allAuthors = authorService.getAll();
//        System.out.println("все аутхоры : "+ allAuthors);
//        System.out.println("--------GenreService-------");
//        final GenreService genreService = run.getBean(GenreService.class);
//        final Genre fiction = genreService.insert(new Genre((long) 1, "Fiction"));
//        final Genre poetry = genreService.insert(new Genre((long) 2, "Poetry"));
//        final List<Genre> allGenres = genreService.getAll();
//        System.out.println("all genres: " + allGenres);
//        final Optional<Genre> genreById = genreService.getById((long) 1);
//        System.out.println("found genre by id 1 -  Fiction "+ genreById);
//
//       // genreService.deleteById((long)2);
//        final List<Genre> allGenres2 = genreService.getAll();
//        System.out.println("all genres, should be 1 " + allGenres2);
//
//        final List<Genre> fiction1 = genreService.getByName("Fiction");
//        System.out.println("getByName, should be Fiction "+ fiction1);

        System.out.println("---------BookService-----------------------------");

        final BookService bookService = run.getBean(BookService.class);
      // final Book book = bookService.createBook(new Book((long) 1, "The wind", new Author((long) 1, "Pushkin", null), new Genre((long) 2, "Poetry"), null));
       // final Book book1 = bookService.createBook(new Book((long) 2, "The wind", new Author((long) 2, "Proust", null), new Genre((long) 1, "Fiction"), null));
       // final List<Book> books = bookService.showAllBooks();
       // System.out.println("all books: "+books);
       final List<Book> proust = bookService.findBookByAuthor(new Author((long) 2, "Proust", null));
        System.out.println("found book by author: "+ proust);
        final Book bookById = bookService.findBookById((long) 1);
        System.out.println("book by id, should be Pushkin "+ bookById);
        final List<Book> poetry1 = bookService.findBookByGenre("Poetry");
        System.out.println("book by genre, should be 1  "+ poetry1);
        final List<Book> the_wind = bookService.findBookByName("The wind");
        System.out.println("book by name, should be 1, the wind  "+ the_wind);
        bookService.deleteBookById((long)1);
        final int size = bookService.showAllBooks().size();
        System.out.println("book quantity, should be one " + size);


//        System.out.println("---------Comments Service----------");
//        final CommentService commentService = run.getBean(CommentService.class);




    }
}
