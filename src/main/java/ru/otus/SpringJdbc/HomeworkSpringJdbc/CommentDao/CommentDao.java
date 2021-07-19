package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

public interface CommentDao {
    Comment insertComment(Comment comment);

    void deleteCommentByBookId(Long id);
}
