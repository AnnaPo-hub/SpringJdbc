//package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;
//
//import lombok.val;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.annotation.DirtiesContext;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.AbstractRepositoryTest;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookDao;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
//class BookDaoTest extends AbstractRepositoryTest {
//
//    @Autowired
//    private BookDao bookDao;
//
//    private Book savedBook;
//    private Author author;
//    private Book testBook;
//
//    @BeforeEach
//    void setUp() {
//        author = new Author((long) 1, "Blok");
//        Genre genre = new Genre((long) 1, "Poetry");
//        testBook = new Book((long) 3, "BookForInsertTest", author, genre);
//        savedBook = bookDao.save(testBook);
//    }
//
//
//    @Test
//    void shouldCreateBook() {
//        final List<String> collect = bookDao.findAll().stream().map(Book::getName).collect(Collectors.toList());
//        Assertions.assertTrue(collect.contains(savedBook.getName()), "Книга не была создана");
//    }
//
//    @Test
//    void shouldShowAllBooks() {
//        Assertions.assertEquals(1, bookDao.findAll().size(), "Не все ожижаемые");
//    }
//
//    @Test
//    void shouldFindBookByName() {
//        final List<Book> the_lady_unknown = bookDao.getByName("BookForInsertTest");
//        Assertions.assertFalse(the_lady_unknown.isEmpty(), "Книга по названию не найдена");
//    }
//
//    @Test
//    void shouldFindBookByAuthor() {
//        final List<Book> blok = bookDao.findBookByAuthor(author.getName());
//        Assertions.assertFalse(blok.isEmpty(), "Книга по имени автора не найдена");
//    }
//
//    @Test
//    void shouldFindBookByGenre() {
//        final List<Book> blok = bookDao.getByGenre("Poetry");
//        Assertions.assertFalse(blok.isEmpty(), "Книга по указанному жанру не найдена");
//    }
//
//    @Test
//    void shouldFindBookById() {
//        val actualBook = bookDao.getById(testBook.getId());
//        assertEquals(actualBook.getName(), testBook.getName());
//    }
//
//    @Test
//    void shouldDeleteBookById() {
//        bookDao.deleteById(savedBook.getId());
//        assertNull(bookDao.getById(savedBook.getId()), "Книга по указанному id не была удалена");
//    }
//}