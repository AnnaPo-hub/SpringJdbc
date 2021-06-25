package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface LibraryService {
    void createBook(Book book);

    List<Book> showAllBooks();

    Book findBookByName(String bookName);

    List <Book> findBookByAuthor(String authorName);

    Book findBookByGenre(String genre);

    Book findBookById(String id);

    int deleteBookById(String id);

}
