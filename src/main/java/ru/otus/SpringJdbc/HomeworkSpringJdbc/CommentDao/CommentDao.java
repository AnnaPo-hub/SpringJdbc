package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentDao {
    Comment insertComment(Comment comment);

    List<Comment> getCommentByBookId(long bookId);

    void deleteCommentByBookId(Long id);
}
