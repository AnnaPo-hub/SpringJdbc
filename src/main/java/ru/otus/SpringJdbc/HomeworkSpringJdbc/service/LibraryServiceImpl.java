package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao.LibraryDao;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {
    LibraryDao libraryDao;

    public LibraryServiceImpl(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    @Transactional
    @Override
    public void createBook(Book book) {
        libraryDao.insertBook(book);
    }

    @Transactional
    @Override
    public List<Book> showAllBooks() {
        return libraryDao.getAll();
    }

    @Transactional
    @Override
    public List<Book> findBookByName(String bookName) {
        return libraryDao.getBookByName(bookName);
    }

    @Transactional
    @Override
    public List<Book> findBookByAuthor(String authorName) {
        return libraryDao.getBookByAuthor(authorName);
    }

    @Transactional
    @Override
    public List<Book> findBookByGenre(String genre) {
        return libraryDao.getBookByGenre(genre);
    }

    @Transactional
    @Override
    public Optional<Book> findBookById(Long id) {
        return libraryDao.getBookById(id);
    }

    @Transactional
    @Override
    public void deleteBookById(Long id) {
        libraryDao.deleteBookById(id);
    }
}
