package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {
     Comment insertCommentByBookId(Comment comment);

    List<Comment> getByBookId(long bookId);

    void deleteByBookId(Long id);
}
