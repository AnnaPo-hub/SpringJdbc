package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.bookDao.BookDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Import({BookDaoJpa.class, AuthorDaoJpa.class, BookServiceImpl.class, AuthorServiceImpl.class})
class BookServiceImplTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    private BookDaoJpa bookDao;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Test
    void shouldCreateBook() {
        Author author = new Author((long) 1, "Blok", null);
        Genre genre = new Genre((long) 1, "Poetry");
        Book testbook = new Book((long) 3, "BookforInsertTest", author, genre, null);
        Book savedBook = bookDao.insertBook(testbook);
        final List<String> collect = bookDao.getAll().stream().map(Book::getName).collect(Collectors.toList());
        Assertions.assertTrue(collect.contains(savedBook.getName()));
    }

    @Test
    void shouldShowAllBooks() {
        Assertions.assertEquals(2, bookDao.getAll().size());
    }

    @Test
    void shouldFindBookByName() {
        final List<Book> the_lady_unknown = bookDao.getBookByName("The nature");
        Assertions.assertFalse(the_lady_unknown.isEmpty());
    }

    @Test
    void shouldFindBookByAuthor() {
        List<Book> books = new ArrayList<>();
        Author author = new Author((long) 1, "Blok", books);
        Genre genre = new Genre((long) 1, "Poetry");
        books.add(new Book((long) 4, "BookforTest", author, genre, null));
        final Author savedAuthor = authorService.insert(author);
        em.refresh(savedAuthor);
        final List<Book> blok = bookService.findBookByAuthor(author);
        Assertions.assertFalse(blok.isEmpty());
    }

    @Test
    void shouldFindBookByGenre() {
        final List<Book> blok = bookDao.getBookByGenre("Poetry");
        Assertions.assertFalse(blok.isEmpty());
    }

    @Test
    void shouldFindBookById() {
        val actualBook = bookDao.getBookById((long) 1);
        val expectedBook = em.find(Book.class, (long) 1);
        assertThat(actualBook).isNotNull().usingRecursiveComparison().isEqualTo(expectedBook);

    }

    @Test
    void shouldDeleteBookById() {
        Author author = new Author((long) 1, "Blok", null);
        Genre genre = new Genre((long) 1, "Poetry");
        Book testbook = new Book((long) 4, "BookforInsertTest", author, genre, null);
        final Book savedBook = bookDao.insertBook(testbook);
        bookDao.deleteBookById(savedBook.getId());
        assertNull(em.find(Book.class, savedBook.getId()));
    }
}