package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;


import java.time.LocalDate;
import java.util.List;

@EnableMongoRepositories
@SpringBootApplication
@EnableWebFlux
public class HomeworkSpringApp {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(HomeworkSpringApp.class, args);

        final Author pushkin = .insert(new Author((long) 1, "Pushkin"));
        System.out.println("добавила аутхора " + pushkin);

        final Author proust = authorService.insert(new Author((long) 2, "Proust"));
        System.out.println("добавила аутхора Пруста " + proust);



        System.out.println("--------GenreService-------");
        final Genre fiction = genreService.insert(new Genre((long) 1, "Fiction"));
        final Genre poetry = genreService.insert(new Genre((long) 2, "Poetry"));

        System.out.println("---------BookService-----------------------------");

        final BookService bookService = run.getBean(BookService.class);
        final Book book = bookService.createBook(new Book((long) 1, "The wind", pushkin, poetry));
        final Book book1 = bookService.createBook(new Book((long) 2, "The wind", proust, fiction));
        final List<Book> books = bookService.showAllBooks();
        System.out.println("all books: " + books);

        final List<Book> proustTest = bookService.findBookByAuthor("Proust");
        System.out.println("Was not OK - found book by author: " + proustTest);//NOT OK

        final Book bookById = bookService.findBookById((long) 1);
        System.out.println("book by id, should be Pushkin " + bookById);


        final List<Book> poetry1 = bookService.findBookByGenre("Poetry");// NOT OK
        System.out.println("Was not OK  - book by genre, should be 1  " + poetry1);

        final List<Book> the_wind = bookService.findBookByName("The wind");
        System.out.println("book by name, should be 1, the wind  " + the_wind);
        // bookService.deleteBookById((long)1);
        final int size = bookService.showAllBooks().size();
        System.out.println("book quantity, should be one " + size);


        System.out.println("---------Comments Service----------");
        final CommentService commentService = run.getBean(CommentService.class);
        final Comment comment = commentService.insertComment(new Comment((long) 1, LocalDate.now(), "Must read", "Alya", book));
        final Comment comment1 = commentService.insertComment(new Comment((long) 2, LocalDate.now(),
                "Great book", "Kate", book1
        ));
        final List<Comment> allByBook = commentService.getByBookId(1);
        System.out.println("comments for book id 1 " + allByBook);

        final Book bookById5 = bookService.findBookById((long) 2);
        System.out.println("book by id 2 " + bookById5);

        commentService.deleteByBookId((long) 1);


    }

}
