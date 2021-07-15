package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao.LibraryRepository;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
@Import({LibraryRepository.class, CommentsJpa.class, GenreDaoJpa.class, AuthorDaoJpa.class})
class CommentsJpaTest {
    Author author = new Author((long) 1, "Blok");
    Genre genre = new Genre((long) 1, "Poetry");
    Book testbook = new Book((long) 4, "BookforInsertCommentTest", author, genre, null);

    @Autowired
    private CommentsJpa commentsJpa;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    void insertComment() {
        libraryRepository.insertBook(testbook);
        Comment testComment = new Comment((long) 2, LocalDate.now(), "Must read", "Vasya", testbook);
        final Comment insertedComment = commentsJpa.insertComment(testComment);
        final Comment comment = em.find(Comment.class, (long) 2);
        Assertions.assertTrue(comment.getComment_text().matches("Must read"));
    }

    @Test
    void getCommentByBookId() {
        final List<Comment> commentByBookId = commentsJpa.getCommentByBookId(1);
        Assertions.assertTrue(commentByBookId.get(0).getComment_text().matches("Good book"));
    }

    @Test
    void deleteCommentByBookId() {
        commentsJpa.deleteCommentByBookId((long) 1);
        Assertions.assertTrue(commentsJpa.getCommentByBookId(1).isEmpty());
    }
}