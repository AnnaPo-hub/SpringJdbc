package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.bookDao.BookDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.BookServiceImpl;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.CommentService;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.CommentServiceImpl;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@DataJpaTest
@Import({BookDaoJpa.class, CommentsDaoJpa.class, GenreDaoJpa.class, AuthorDaoJpa.class, CommentServiceImpl.class, BookServiceImpl.class})
class CommentsDaoJpaTest {
    Author author = new Author((long) 1, "Blok", null);
    Genre genre = new Genre((long) 1, "Poetry");
    Book testbook = new Book((long) 3, "BookforInsertCommentTest", author, genre, null);
    Comment testComment = new Comment((long) 2, LocalDate.now(), "Must read", "Vasya", testbook);


    @Autowired
    private CommentsDaoJpa commentsDaoJpa;

    @Autowired
    private BookDaoJpa libraryRepository;

    @Autowired
    private TestEntityManager em;

    @Autowired
    private CommentService commentService;

    @BeforeEach
    void setUp() {
        libraryRepository.insertBook(testbook);
    }

    @DirtiesContext
    @Test
    public void insertComment() {

        final Comment insertedComment = commentsDaoJpa.insertComment(testComment);
        final Comment comment = em.find(Comment.class, insertedComment.getId());
        Assertions.assertTrue(comment.getComment_text().matches("Must read"));
    }

    @DirtiesContext
    @Test
    public void getCommentByBookId() {
        final Comment comment = commentsDaoJpa.insertComment(testComment);
        em.refresh(comment);
        final List<Comment> commentByBookId = commentService.getCommentByBookId(testbook.getId());
        Assertions.assertTrue(commentByBookId.get(0).getComment_text().matches("Must read"));
    }

    @DirtiesContext
    @Test
    public void deleteCommentByBookId() {
        final Comment insertedComment = commentsDaoJpa.insertComment(testComment);
        final Comment comment = em.find(Comment.class, testComment.getId());
        assertThat(comment).isNotNull();
        //em.detach(comment);

        commentsDaoJpa.deleteCommentByBookId(testbook.getId());

        val deletedComment = em.find(Comment.class, insertedComment.getId());
        assertThat(deletedComment).isNull();
    }
}