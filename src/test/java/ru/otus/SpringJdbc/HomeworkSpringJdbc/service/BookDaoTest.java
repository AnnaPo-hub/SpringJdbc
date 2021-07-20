package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@Import({BookDao.class,  BookServiceImpl.class})
@ComponentScan
class BookDaoTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    private BookDao bookDao;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private GenreService genreService;

    private Author author = new Author((long) 1, "Blok", null);
    private Author existingAuthor = new Author((long) 2, "Dostoevskiy", null);
    private Genre genre = new Genre((long) 1, "Poetry");
    private Book testbook = new Book((long) 6, "BookforInsertTest", author, genre, null);

    @Test
    void shouldCreateBook() {
        Book savedBook = bookDao.save(testbook);
        final List<String> collect = bookDao.findAll().stream().map(Book::getName).collect(Collectors.toList());
        assertTrue(collect.contains(savedBook.getName()), "Не удалось внести кнингу в БД");
    }

    @Test
    void shouldShowAllBooks() {
        Assertions.assertEquals(2, bookDao.findAll().size(),
                "Фактическое количество книг в БД не соответствует ожидаемому");
    }

    @Test
    void shouldFindBookByName() {
        final List<Book> the_lady_unknown = bookDao.getByName("The nature");
        Assertions.assertFalse(the_lady_unknown.isEmpty(), "Не удалось найти книгу по указанному названию");
    }

    @Test
    void shouldFindBookByAuthor() {
        final Genre insertedGenre = genreService.insert(genre);
        final Author pushkin = authorService.insert(new Author((long) 3, "Pushkin", null));
        List<Book> books = new ArrayList<>();
        books.add(bookDao.save(new Book((long) 7, "Captain's Daughter", pushkin, insertedGenre, null)));
        em.refresh(pushkin);
        final List<Book> bookByAuthor = bookService.findBookByAuthor(pushkin);
        Assertions.assertFalse(bookByAuthor.isEmpty(), "Не удалось найти книгу по указанному автору");
    }

    @Test
    void shouldFindBookByGenre() {
        final List<Book> blok = bookDao.getByGenreName("Poetry");
        Assertions.assertFalse(blok.isEmpty(), "Не удалось найти книгу по указанному жанру");
    }

    @Test
    void shouldFindBookById() {
        val actualBook = bookDao.getById((long) 1);
        val expectedBook = em.find(Book.class, (long) 1);
        assertEquals(expectedBook, actualBook, "Не удалось найти книгу по указанному id");
    }

    @Test
    void shouldDeleteBookById() {
        final Book savedBook = bookDao.save(testbook);
        bookDao.deleteById(savedBook.getId());
        assertNull(em.find(Book.class, savedBook.getId()), "Не удалось удалить книгу по указанному id");
    }
}
