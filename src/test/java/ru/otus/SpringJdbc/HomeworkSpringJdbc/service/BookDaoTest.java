package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao.BookDao;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookDaoTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    BookDao bookDao;

    @Test
    void shouldCreateBook() {
        Author author = new Author((long) 1, "Blok");
        Genre genre = new Genre((long) 1, "Poetry");
        Book testbook = new Book((long) 3, "BookforInsertTest", author, genre, null);
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
        final List<Book> blok = bookDao.getByAuthorName("Blok");
        Assertions.assertFalse(blok.isEmpty(), "Не удалось найти книгу по указанному автору");
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
        Author author = new Author((long) 1, "Blok");
        Genre genre = new Genre((long) 1, "Poetry");
        Book testbook = new Book((long) 6, "BookforInsertTest", author, genre, null);
        final Book savedBook = bookDao.save(testbook);
        bookDao.deleteById(savedBook.getId());
        assertNull(em.find(Book.class, savedBook.getId()), "Не удалось удалить книгу по указанному id");
    }
}
