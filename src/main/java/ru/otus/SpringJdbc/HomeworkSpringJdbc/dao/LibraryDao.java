package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface LibraryDao {
    List<Book> getAll();

    List <Book>  getBookByName(String bookName);

    List <Book> getBookByAuthor(String authorName);

    List <Book> getBookByGenre(String genre);

    Book getBookById(String id);

    int insertBook(Book book);

    int deleteBookById(String id);


}
