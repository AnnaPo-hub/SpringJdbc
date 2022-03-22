package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

@Component
public interface CommentDao extends JpaRepository<Comment, Long> {
    void deleteByBookId(Long id);
}
