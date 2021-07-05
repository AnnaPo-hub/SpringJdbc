package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface LibraryService {
    void createBook(String bookName, String author, String genre);

    List<Book> showAllBooks();

    List<Book> findBookByName(String bookName);

    List<Book> findBookByAuthor(String authorName);

    List<Book> findBookByGenre(String genre);

    Book findBookById(Long id);

    int deleteBookById(Long id);
}
