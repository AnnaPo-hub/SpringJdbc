package ru.otus.SpringJdbc.HomeworkSpringJdbc;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.LibraryService;

import java.util.List;

@ShellComponent
public class HelloShell {

    private final LibraryService service;

    public HelloShell(LibraryService service) {
        this.service = service;
    }

    @ShellMethod(value = "createBook", key = {"create", "c"})
    public void createBook( String bookName, String author,  String genre ) {
        service.createBook(bookName, author, genre);
    }

    @ShellMethod(value = "findBookByName", key = {"findByName", "fn"})
    public List<Book> findBookByName(String bookName) {
        return service.findBookByName(bookName);
    }

    @ShellMethod(value = "findBookByAuthor", key = {"findByAuthor", "fa"})
    public List<Book> findBookByAuthor(String author) {
        return service.findBookByAuthor(author);
    }

    @ShellMethod(value = "findBookByGenre", key = {"findByGender", "fg"})
    public List<Book> findBookByGenre(String genre) {
        return service.findBookByGenre(genre);
    }

    @ShellMethod(value = "findBookById", key = {"findById", "fi"})
    public Book findBookById(Long id) {
        return service.findBookById(id);
    }

    @ShellMethod(value = "deleteBookById", key = {"deleteBookById", "d"})
    public int deleteBookById(Long id) {
        return service.deleteBookById(id);
    }
}
