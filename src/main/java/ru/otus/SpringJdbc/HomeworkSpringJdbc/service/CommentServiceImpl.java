package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.CommentDao;

import java.util.List;

@Component
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @Override
    public List<Comment> getByBookId(long bookId) {
        return commentDao.getAllByBookId(bookId);
    }

    @Transactional
    @Override
    public void deleteByBookId(Long id) {
        commentDao.deleteByBookId(id);
    }

    @Transactional
    @Override
    public Comment insertComment(Comment comment) {
        return commentDao.insert(comment);
    }
}


