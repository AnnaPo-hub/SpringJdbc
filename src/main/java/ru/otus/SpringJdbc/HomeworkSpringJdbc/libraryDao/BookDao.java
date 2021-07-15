package ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {
    List<Book> getAll();

    List<Book> getBookByName(String bookName);

    List<Book> getBookByAuthor(String authorName);

    List<Book> getBookByGenre(String genre);

    Optional<Book> getBookById(Long id);

    Book insertBook(Book book);

    void deleteBookById(Long id);
}
