package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.BookDao;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    BookDao bookDao;

    @Transactional
    @Override
    public void createBook(Book book) {
        bookDao.save(book);
    }

    @Transactional
    @Override
    public List<Book> showAllBooks() {
        return bookDao.findAll();
    }

    @Transactional
    @Override
    public List<Book> findBookByName(String bookName) {
        return bookDao.getByName(bookName);
    }

    @Transactional
    @Override
    public List<Book> findBookByAuthor(String authorName) {
        return bookDao.getByAuthorName(authorName);
    }

    @Transactional
    @Override
    public List<Book> findBookByGenre(String genre) {
        return bookDao.getByGenreName(genre);
    }

    @Transactional
    @Override
    public Optional<Book> findBookById(Long id) {
        return bookDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteBookById(Long id) {
        bookDao.deleteById(id);
    }
}
