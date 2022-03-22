package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentDao extends MongoRepository<Comment, String> {
    @Query(value = "{'book_id._id': ?0}", fields = "{'comment_text': 1, 'author': 1}")
    List<Comment> getAllByBookId(Long id);

    void deleteByBookId(Long id);
}
