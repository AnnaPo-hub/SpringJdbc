package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getAllByBook(Long id);

    void deleteCommentByBookId(Long id);
}
