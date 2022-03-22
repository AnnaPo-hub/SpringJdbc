package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;
@Service
public interface CommentService {
    List<Comment> getByBookId(long bookId);

    void deleteCommentByBookId(Long id);

    void insertComment(Comment comment);
}
