package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

public interface CommentDao {
    Comment insertComment(Comment comment);

    Comment getCommentByBookId(long bookId);


    void deleteCommentByBookId(Long id);

}
