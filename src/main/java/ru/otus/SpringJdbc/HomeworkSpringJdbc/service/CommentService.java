package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;
@Component
public interface CommentService {

    List<Comment> getByBookId(long bookId);

    void deleteCommentByBookId(Long id);

    void insertComment(Comment comment);
}
