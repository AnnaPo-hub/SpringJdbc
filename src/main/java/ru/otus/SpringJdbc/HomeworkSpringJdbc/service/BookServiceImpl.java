package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class BookServiceImpl implements BookService {
   private final BookDao bookDao;

    @Transactional
    @Override
    public Book createBook(Book book) {
      return bookDao.save(book);
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
    public List<Book> findBookByGenre(String genre) {
        return bookDao.getByGenreName(genre);
    }


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
