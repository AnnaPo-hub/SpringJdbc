package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.LibraryDaoJdbc;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@JdbcTest
@Import({LibraryDaoJdbc.class, LibraryServiceImpl.class})
class LibraryServiceImplTest {

    Book bookToAdd = new Book((long) 3, "The poems", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"));
    Book existingBook = new Book((long) 2, "The lady unknown", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"));
    @Autowired
    LibraryService libraryService;

    @Test
    void shouldCreateBook() {
        libraryService.createBook(bookToAdd);
        Assertions.assertEquals(1, libraryService.findBookByName("The poems").size());
    }

    @Test
    void shouldShowAllBooks() {
        Assertions.assertEquals(2, libraryService.showAllBooks().size());
    }

    @Test
    void shouldFindBookByName() {
        final List<Book> the_lady_unknown = libraryService.findBookByName("The lady unknown");
        Assertions.assertTrue(the_lady_unknown.contains(existingBook));
    }

    @Test
    void shouldFindBookByAuthor() {
        final List<Book> block = libraryService.findBookByAuthor("Blok");
        Assertions.assertTrue(block.size() == 2);

    }

    @Test
    void shouldFindBookByGenre() {
        final List<Book> poetry = libraryService.findBookByGenre("Poetry");
        Assertions.assertTrue(poetry.size() == 2);
    }

    @Test
    void shouldFindBookById() {
        final Book bookById = libraryService.findBookById((long) 2);
        assertThat(bookById, is(equalTo(existingBook)));
    }

    @Test
    void shouldDeleteBookById() {
        libraryService.deleteBookById((long) 1);
        final Book bookById = libraryService.findBookById((long) 1);
        Assertions.assertNull(bookById);
    }
}