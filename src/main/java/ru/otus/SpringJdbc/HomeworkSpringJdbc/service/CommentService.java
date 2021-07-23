package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByBook(long bookId);

    List<Comment> getCommentByBookId(long bookId);

    void deleteCommentByBookId(Long id);

   // Comment insertComment(Comment comment);
}
