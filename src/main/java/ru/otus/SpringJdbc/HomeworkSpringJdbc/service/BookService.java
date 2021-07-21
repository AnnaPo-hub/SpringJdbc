package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface BookService {
    void createBook(Book book);

    List<Book> showAllBooks();

    List<Book> findBookByName(String bookName);

    List<Book> findBookByAuthor(Author author);

    List<Book> findBookByGenre(String genre);

    Book findBookById(Long id);

    void deleteBookById(Long id);
}
