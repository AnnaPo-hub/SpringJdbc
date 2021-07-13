package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;
import java.util.Optional;

public interface LibraryService {
    void createBook(Book book);

    List<Book> showAllBooks();

    List<Book> findBookByName(String bookName);

    List<Book> findBookByAuthor(String authorName);

    List<Book> findBookByGenre(String genre);

    Optional<Book> findBookById(Long id);

    void deleteBookById(Long id);
}
