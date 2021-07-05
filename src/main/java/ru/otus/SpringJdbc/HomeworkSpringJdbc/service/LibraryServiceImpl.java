package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.LibraryDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    LibraryDao libraryDao;

    public LibraryServiceImpl(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    @Override
    public void createBook(String bookName, String author, String genre) {
        libraryDao.insertBook(bookName, author, genre);
    }

    @Override
    public List<Book> showAllBooks() {
        return libraryDao.getAll();
    }

    @Override
    public List<Book> findBookByName(String bookName) {
        return libraryDao.getBookByName(bookName);
    }

    @Override
    public List<Book> findBookByAuthor(String authorName) {
        return libraryDao.getBookByAuthor(authorName);
    }

    @Override
    public List<Book> findBookByGenre(String genre) {
        return libraryDao.getBookByGenre(genre);
    }

    @Override
    public Book findBookById(Long id) {
        return libraryDao.getBookById(id);
    }

    @Override
    public int deleteBookById(Long id) {
        return libraryDao.deleteBookById(id);
    }
}
