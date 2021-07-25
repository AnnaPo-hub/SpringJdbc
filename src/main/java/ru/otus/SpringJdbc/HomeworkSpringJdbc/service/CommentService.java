package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<Comment> getAllByBook(long bookId);

    List<CommentDto> getCommentByBookId(long bookId);

    void deleteCommentByBookId(Long id);

    Comment insertComment(Comment comment);
}
