package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface LibraryService {
    void createBook(Book book);

    List<Book> showAllBooks();

    List <Book> findBookByName(String bookName);

    List<Book> findBookByAuthor(String authorName);

    List<Book> findBookByGenre(String genre);

//    List<Book> findBookById(String id);

    int deleteBookById(String id);

}
