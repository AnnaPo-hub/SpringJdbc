package ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;
import java.util.Optional;

public interface LibraryDao {
    List<Book> getAll();

    Optional<Book>  getBookByName(String bookName);

    Optional<Book>  getBookByAuthor(String authorName);

    Optional<Book>  getBookByGenre(String genre);

    Optional<Book> getBookById(Long id);

    Book insertBook(Book book);

    void deleteBookById(Long id);


}
