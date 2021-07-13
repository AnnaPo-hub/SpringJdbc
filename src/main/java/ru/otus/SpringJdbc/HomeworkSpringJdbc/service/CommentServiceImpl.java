package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;

    @Transactional
    @Override
    public Comment getCommentByBookId(long bookId) {
        return commentDao.getCommentByBookId(bookId);
    }

    @Transactional
    @Override
    public void deleteCommentByBookId(Long id) {
        commentDao.deleteCommentByBookId(id);
    }

    @Transactional
    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }
}
