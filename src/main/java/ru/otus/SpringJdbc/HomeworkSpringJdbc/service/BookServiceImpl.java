package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Transactional
    @Override
    public Book createBook(Book book) {
      return  bookDao.insert(book);
    }

    @Override
    public List<Book> showAllBooks() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findBookByName(String bookName) {
        return bookDao.getByName(bookName);
    }

    @Override
    public List<Book> findBookByAuthor(Author author) {
        return author.getBooks();
    }

    @Override
    public List<Book> findBookByGenre(String genre) {
        return bookDao.getByGenre(genre);
    }

    @Override
    public Book findBookById(Long id) {
        return bookDao.getById(id);
    }

    @Transactional
    @Override
    public void deleteBookById(Long id) {
        bookDao.deleteById(id);
    }
}
