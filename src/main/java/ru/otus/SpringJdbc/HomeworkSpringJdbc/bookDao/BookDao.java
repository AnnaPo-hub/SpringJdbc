package ru.otus.SpringJdbc.HomeworkSpringJdbc.bookDao;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAll();

    List<Book> getBookByName(String bookName);

    List<Book> getBookByGenre(String genre);

    Book getBookById(Long id);

    Book insertBook(Book book);

    void deleteBookById(Long id);
}
