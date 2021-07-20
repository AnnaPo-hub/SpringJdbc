package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getByBookId(long bookId);

    void deleteCommentByBookId(Long id);

    void insertComment(Comment comment);
}
