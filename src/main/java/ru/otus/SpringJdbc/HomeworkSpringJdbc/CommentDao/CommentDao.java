package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getAllByBookId(long bookId);

    Comment insertComment(Comment comment, long bookId);

    void deleteCommentByBookId(Long id);

}
