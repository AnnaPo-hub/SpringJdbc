package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DataJpaTest
class CommentTest {
    Author author = new Author((long) 1, "Blok");
    Genre genre = new Genre((long) 1, "Poetry");
    Book testBook = new Book((long) 3, "BookforInsertCommentTest", author, genre, null);
    Comment testComment = new Comment((long) 2, LocalDate.now(), "Must read", "Vasya", testBook);

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private TestEntityManager em;


    private static Comment insertedComment;

    @BeforeEach
    void setUp() {
        insertedComment = commentDao.save(testComment);
    }

    @DirtiesContext
    @Test
    public void insertComment() {
        val comment = em.find(Comment.class, insertedComment.getId());
        assertTrue(comment.getComment_text().matches("Must read"),
                "Не удалось добавить в БД комментарий");
    }

    @DirtiesContext
    @Test
    public void getCommentByBookId() {
        val commentByBookId = commentDao.getByBookId(testBook.getId());
        assertTrue(commentByBookId.get(0).getComment_text().matches("Must read"),
                "Не удалось найти комментарий по указанному id");
    }

    @DirtiesContext
    @Test
    public void deleteCommentByBookId() {
        val comment = em.find(Comment.class, testComment.getId());
        assertThat(comment).isNotNull();
        em.detach(comment);
        commentDao.deleteByBookId(testBook.getId());
        val deletedComment = em.find(Comment.class, insertedComment.getId());
        assertThat(deletedComment).isNull();
    }
}