package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao.LibraryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@JdbcTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Import({LibraryRepository.class, LibraryServiceImpl.class})
class LibraryServiceImplTest {
    List<Comment> comments;

    Book bookToAdd = new Book((long) 3, "The poems", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"),comments);
    Book existingBook1 = new Book((long) 1, "The dark Maiden", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"),comments);
    Book existingBook2 = new Book((long) 2, "The lady unknown", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"),comments);
    List<Book> library = new ArrayList<>();

    @BeforeAll
    void setUp() {
        comments.add(new Comment( (long)10, LocalDate.now(), "Good book", "Alicia", existingBook1));
        library.add(existingBook1);
        library.add(existingBook2);
    }

    @Autowired
    LibraryService libraryService;

    @Test
    void shouldCreateBook() {
        libraryService.createBook(bookToAdd);
        libraryService.findBookById((long) 3);
        Assertions.assertEquals(bookToAdd, libraryService.findBookById((long) 3));
    }

    @Test
    void shouldShowAllBooks() {
        Assertions.assertEquals(2, libraryService.showAllBooks().size());
    }

//    @Test
//    void shouldFindBookByName() {
//        final Optional<Book> the_lady_unknown = libraryService.findBookByName("The lady unknown");
//        Assertions.assertTrue(the_lady_unknown.contains(existingBook1));
//    }

    @Test
    void shouldFindBookByAuthor() {
        Assertions.assertEquals(library, libraryService.findBookByAuthor("Blok"));
    }

    @Test
    void shouldFindBookByGenre() {
        Assertions.assertEquals(library, libraryService.findBookByGenre("Poetry"));
    }

    @Test
    void shouldFindBookById() {
        final Optional<Book> bookById = libraryService.findBookById((long) 2);
        assertThat(bookById, is(equalTo(existingBook1)));
    }

    @Test
    void shouldDeleteBookById() {
        libraryService.deleteBookById((long) 1);
        Assertions.assertNull(libraryService.findBookById((long) 1));
    }
}