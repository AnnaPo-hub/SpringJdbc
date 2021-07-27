package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.AbstractRepositoryTest;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.CommentDao;

import java.time.LocalDate;
import java.util.List;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CommentsDaoTest extends AbstractRepositoryTest {
    private final Genre genre = new Genre((long) 1, "Poetry");
    private Author author = new Author((long) 1, "Blok");
    private Book testbook = new Book((long) 3, "BookforInsertCommentTest", author, genre);
    private final Comment testComment = new Comment((long) 2, LocalDate.now(), "Must read", "Vasya", testbook);

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BookDao libraryRepository;


    @BeforeEach
    void setUp() {
        libraryRepository.insert(testbook);
        commentDao.insert(testComment);
    }

    @Test
    public void insertComment() {
        final List<Comment> allByBookId = commentDao.getAllByBookId((testbook.getId()));
        Assertions.assertEquals("Must read", allByBookId.get(0).getComment_text(), "Комментарий не был добавлен");
    }

    @Test
    public void getCommentByBookId() {
        final List<Comment> commentByBookId = commentDao.getAllByBookId(testbook.getId());
        Assertions.assertTrue(commentByBookId.get(0).getComment_text().matches("Must read"), "Комментарий по указанному id книги не найден");
    }

    @Test
    public void deleteCommentByBookId() {
        commentDao.deleteByBookId(testbook.getId());
        final List<Comment> all = commentDao.getAllByBookId(testbook.getId());
        Assertions.assertEquals(0, all.size(), "Комментарий по указанному id книги не был удален");
    }
}
