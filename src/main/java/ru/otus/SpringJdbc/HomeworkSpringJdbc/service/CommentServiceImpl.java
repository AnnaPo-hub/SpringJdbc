package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;
   // CommentDao commentDaoCustom;

    @Transactional
    @Override
    public List<Comment> getCommentByBookId(long bookId) {
        return commentDao.getByBookId(bookId);
    }

    @Transactional
    @Override
    public void deleteCommentByBookId(Long id) {
        commentDao.deleteByBookId(id);
    }

    @Transactional
    @Override
    public void insertComment(Comment comment) {
        commentDao.save(comment);
    }
}
