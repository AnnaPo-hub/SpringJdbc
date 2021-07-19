package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.bookDao.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;


    @Transactional
    @Override
    public void createBook(Book book) {
        bookDao.insertBook(book);
    }

    @Transactional
    @Override
    public List<Book> showAllBooks() {
        return bookDao.getAll();
    }

    @Transactional
    @Override
    public List<Book> findBookByName(String bookName) {
        return bookDao.getBookByName(bookName);
    }

    @Transactional
    @Override
    public List<Book> findBookByAuthor(Author author) {
        return author.getBooks();
    }

    @Transactional
    @Override
    public List<Book> findBookByGenre(String genre) {
        return bookDao.getBookByGenre(genre);
    }

    @Transactional
    @Override
    public Optional<Book> findBookById(Long id) {
        return bookDao.getBookById(id);
    }

    @Transactional
    @Override
    public void deleteBookById(Long id) {
        bookDao.deleteBookById(id);
    }


}
