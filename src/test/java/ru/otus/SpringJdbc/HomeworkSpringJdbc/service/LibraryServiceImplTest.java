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

import static org.junit.jupiter.api.Assertions.assertTrue;

@JdbcTest
@Import({LibraryDaoJdbc.class, LibraryServiceImpl.class})
class LibraryServiceImplTest {

    Book bookToAdd = new Book((long) 3, "The poems", new Author((long) 1, "Block"), new Genre((long) 1, "Poetry"));
    Book existingBook = new Book((long) 2, "The lady unknown", new Author((long) 1, "Block"), new Genre((long) 1, "Poetry"));
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
    void shouldFindBookByName() {// сравнить, что полученный по поиску объем и есть тот, который нужен
        assertTrue(libraryService.findBookByName("The lady unknown").contains(existingBook));
    }

    @Test
    void shouldFindBookByAuthor() {
    }

    @Test
    void shouldFindBookByGenre() {
    }

    @Test
    void shouldFindBookById() {
    }

    @Test
    void shouldDeleteBookById() {
    }

}