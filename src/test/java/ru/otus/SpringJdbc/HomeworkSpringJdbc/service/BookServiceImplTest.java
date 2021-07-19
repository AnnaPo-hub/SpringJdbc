package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentsJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Import({BookRepository.class, CommentsJpa.class, GenreDaoJpa.class, AuthorDaoJpa.class})
class BookServiceImplTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    BookRepository libraryRepository;

    @Test
    void shouldCreateBook() {
        Author author = new Author((long) 1, "Blok");
        Genre genre = new Genre((long) 1, "Poetry");
        Book testbook = new Book((long) 3, "BookforInsertTest", author, genre, null);
        Book savedBook = libraryRepository.insertBook(testbook);
        final List<String> collect = libraryRepository.getAll().stream().map(Book::getName).collect(Collectors.toList());
        Assertions.assertTrue(collect.contains(savedBook.getName()));
    }

    @Test
    void shouldShowAllBooks() {
        final List<Book> all = libraryRepository.getAll();
        Assertions.assertEquals(2, libraryRepository.getAll().size());
    }

    @Test
    void shouldFindBookByName() {
        final List<Book> the_lady_unknown = libraryRepository.getBookByName("The nature");
        Assertions.assertFalse(the_lady_unknown.isEmpty());
    }

    @Test
    void shouldFindBookByAuthor() {
        final List<Book> blok = libraryRepository.getBookByAuthor("Blok");
        Assertions.assertFalse(blok.isEmpty());
    }

    @Test
    void shouldFindBookByGenre() {
        final List<Book> blok = libraryRepository.getBookByGenre("Poetry");
        Assertions.assertFalse(blok.isEmpty());
    }

    @Test
    void shouldFindBookById() {
        val actualBook = libraryRepository.getBookById((long) 1);
        val expectedBook = em.find(Book.class, (long) 1);
        assertThat(actualBook).isPresent().get().usingRecursiveComparison().isEqualTo(expectedBook);

    }

    @Test
    void shouldDeleteBookById() {
        Author author = new Author((long) 1, "Blok");
        Genre genre = new Genre((long) 1, "Poetry");
        Book testbook = new Book((long) 4, "BookforInsertTest", author, genre, null);
        final Book savedBook = libraryRepository.insertBook(testbook);
        libraryRepository.deleteBookById(savedBook.getId());
        assertNull(em.find(Book.class, savedBook.getId()));
    }
}