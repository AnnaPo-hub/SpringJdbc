package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkSpringApp {

    public static void main(String[] args) throws SQLException {
        final ConfigurableApplicationContext run = SpringApplication.run(HomeworkSpringApp.class, args);
//        final CommentService bean = run.getBean(CommentService.class);
//        final BookService bean2 = run.getBean(BookService.class);
//        final GenreService bean3 = run.getBean(GenreService.class);
//        Genre genre = new Genre((long)1, "POetry");
//        bean3.insert(genre);
//        List<Comment> comments = new ArrayList<>();
//        comments.add(new Comment((long)1, LocalDate.now(),"must read", "Petya", new Book((long)1, "ll", new Author((long)1, "Book", null), new Genre((long)1, "POetry"), comments)));
//        bean2.createBook(new Book((long)1, "ll", new Author((long)1, "Book", null), genre , comments));
//        final List<Comment> commentByBookId = bean.getCommentByBookId(1);
//        System.out.println(commentByBookId);


        Console.main(args);

    }
}
