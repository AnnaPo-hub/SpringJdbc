package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.LibraryDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    LibraryDao libraryDao;

    public LibraryServiceImpl(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    @Override
    public void createBook(Book book) {
        libraryDao.insertBook(book);
    }

    @Override
    public List<Book> showAllBooks() {
        return libraryDao.getAll();
    }

    @Override
    public Book findBookByName(String bookName) {
        return libraryDao.getBookByName(bookName);
    }

    @Override
    public Book findBookByAuthor(String authorName) {
        return libraryDao.getBookByAuthor(authorName);
    }

    @Override
    public Book findBookByGenre(String genre) {
        return libraryDao.getBookByGenre(genre);
    }

    @Override
    public Book deleteBookById(String id) {
        return libraryDao.getBookById(id);

    }
}
