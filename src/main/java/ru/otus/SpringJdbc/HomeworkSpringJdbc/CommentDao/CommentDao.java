package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getAll();

    Comment insertComment(Comment comment);

    void deleteCommentById(Long id);

    int deleteAll();

}
