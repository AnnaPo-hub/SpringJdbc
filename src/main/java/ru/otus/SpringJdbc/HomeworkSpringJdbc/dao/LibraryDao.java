package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface LibraryDao {
    List<Book> getAll();

    Book getBookByName(String bookName);

    Book getBookByAuthor(String authorName);

    Book getBookByGenre(String genre);

    Book getBookById(String id);

    int insertBook(Book book);

    int deleteBookById(String id);


}
