package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Import(CommentsJpa.class)
class CommentsJpaTest {

    @Autowired
    private CommentsJpa  commentsJpa;

    @Autowired
    private TestEntityManager em;

    @Test
    void insertComment() {
    }

    @Test
    void getCommentByBookId() {
    }

    @Test
    void deleteCommentByBookId() {
    }
}