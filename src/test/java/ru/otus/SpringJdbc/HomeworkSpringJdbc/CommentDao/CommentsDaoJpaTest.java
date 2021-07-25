package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

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
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dto.CommentDto;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.BookServiceImpl;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.CommentService;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.CommentServiceImpl;

import java.time.LocalDate;
import java.util.List;


@Transactional
@DataJpaTest
@Import({BookDaoJpa.class, CommentsDaoJpa.class, GenreDaoJpa.class, AuthorDaoJpa.class, CommentServiceImpl.class, BookServiceImpl.class})
class CommentsDaoJpaTest {
    private final Genre genre = new Genre((long) 1, "Poetry");
    private Author author = new Author((long) 1, "Blok", null);
    private Book testbook = new Book((long) 3, "BookforInsertCommentTest", author, genre, null);
    private final Comment testComment = new Comment((long) 2, LocalDate.now(), "Must read", "Vasya", testbook);
    private final Comment testComment2 = new Comment((long) 3, LocalDate.now(), "Great book!!", "Olga", testbook);
    private Comment insertedComment;

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
        insertedComment = commentService.insertComment(testComment);
    }

    @DirtiesContext
    @Test
    public void insertComment() {
        final Comment comment = em.find(Comment.class, insertedComment.getId());
        Assertions.assertTrue(comment.getComment_text().matches("Must read"));
    }

    @DirtiesContext
    @Test
    public void getCommentByBookId() {
       // final Comment comment = commentService.insertComment(testComment2);
       // em.refresh(insertedComment);
      //  em.refresh(comment);
        final List<CommentDto> commentByBookId = commentService.getCommentByBookId(testbook.getId());
        System.out.println(commentByBookId);
       // Assertions.assertTrue(commentByBookId.get(0).getComment_text().matches("Must read"));
    }

    @DirtiesContext
    @Test
    public void deleteCommentByBookId() {
        em.refresh(insertedComment);
        commentsDaoJpa.deleteCommentByBookId(testbook.getId());
        final List<Comment> all = commentService.getAllByBook(testbook.getId());
        Assertions.assertEquals(0, all.size());
    }
}
