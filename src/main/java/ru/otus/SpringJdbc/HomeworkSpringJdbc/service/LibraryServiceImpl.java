package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.LibraryDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.BookBo;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    LibraryDao libraryDao;

    public LibraryServiceImpl(LibraryDao libraryDao) {
        this.libraryDao = libraryDao;
    }

    @Override
    public void createBook(BookBo book) {
        libraryDao.insertBook(book);
    }

    @Override
    public List<BookBo> showAllBooks() {
        final List<BookBo> all = libraryDao.getAll();
        return all;
    }
}
