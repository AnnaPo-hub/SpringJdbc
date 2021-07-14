package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

@DataJpaTest
@Import(CommentsJpa.class)
class CommentsJpaTest {

    @Autowired
    private CommentsJpa commentsJpa;

    @Autowired
    private TestEntityManager em;

    @Test
    void insertComment() {
    }

    @Test
    void getCommentByBookId() {
        final List<Comment> commentByBookId = commentsJpa.getCommentByBookId(1);
        System.out.println(commentByBookId);

    }

    @Test
    void deleteCommentByBookId() {

    }
}