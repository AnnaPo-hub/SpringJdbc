package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentsJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao.LibraryRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Import({LibraryRepository.class, CommentsJpa.class, GenreDaoJpa.class, AuthorDaoJpa.class})
class LibraryServiceImplTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    LibraryRepository libraryRepository;

    List<Comment> comments;

    Book bookToAdd =new Book((long) 3,"The poems",new Author((long) 1,"Blok"),new Genre((long) 1,"Poetry"),comments);

    Book existingBook1;
    Book  existingBook2 = new Book((long) 2, "The lady unknown", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"), comments);
    List<Book> library = new ArrayList<>();



//    @BeforeAll
//    void setUp() {
//        existingBook1 = new Book((long) 1, "The dark Maiden", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"), comments);
//        existingBook2 = new Book((long) 2, "The lady unknown", new Author((long) 1, "Blok"), new Genre((long) 1, "Poetry"), comments);
//        comments.add(new Comment((long) 10, LocalDate.now(), "Good book", "Alicia", existingBook1));
//        library.add(existingBook1);
//        library.add(existingBook2);
//    }


    @Test
    void shouldCreateBook() {
        Author author = new Author((long) 1, "Blok");
        Genre genre = new Genre((long) 1, "Poetry");
        Comment comment = new Comment((long)1, LocalDate.now(), "Good Book", "Anya", null);
        Book testbook = new Book((long)1, "BookforInsertTest", author, genre, null);
        Book savedBook = libraryRepository.insertBook(testbook);
        final List<String> collect = libraryRepository.getAll().stream().map(Book::getName).collect(Collectors.toList());
        Assertions.assertTrue(collect.contains(testbook.getName()));

//        final Book book = libraryRepository.insertBook(bookToAdd);
//        Assertions.assertTrue(libraryRepository.getAll().contains(book));
        // libraryRepository.getBookById((long) 3);
       // Assertions.assertEquals(bookToAdd.getName(),libraryRepository.getBookById((long) 3));
    }

    @Test
    void shouldShowAllBooks() {
        final List<Book> all = libraryRepository.getAll();
        System.out.println(all);

        Assertions.assertEquals(2, libraryRepository.getAll().size());
    }

    @Test
    void shouldFindBookByName() {
        final List<Book> the_lady_unknown = libraryRepository.getBookByName("The lady unknown");
        Assertions.assertTrue(the_lady_unknown.contains(existingBook2));
    }

    @Test
    void shouldFindBookByAuthor() {
        Assertions.assertEquals(library, libraryRepository.getBookByAuthor("Blok"));
    }

    @Test
    void shouldFindBookByGenre() {
        Assertions.assertEquals(library, libraryRepository.getBookByGenre("Poetry"));
    }

    @Test
    void shouldFindBookById() {
        final Optional<Book> bookById = libraryRepository.getBookById((long) 2);
        assertThat(bookById, is(equalTo(existingBook1)));
    }

    @Test
    void shouldDeleteBookById() {
        libraryRepository.deleteBookById((long) 1);
        Assertions.assertNull(libraryRepository.getBookById((long) 1));
    }
}