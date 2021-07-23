package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentDao extends MongoRepository<Comment, String> {
    List<Comment> getAllByBook(Long id);

    void deleteCommentByBookId(Long id);
}
