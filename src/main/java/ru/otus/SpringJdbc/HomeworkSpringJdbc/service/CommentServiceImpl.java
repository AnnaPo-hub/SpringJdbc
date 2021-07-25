package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.CommentDao;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;
    private final BookService bookService;


    @Override
    public List<Comment> getAllByBook(long bookId) {
        return commentDao.getAllByBook(bookId);
    }

    @Override
    public List<Comment> getByBookId(long bookId) {
        List<Comment> comments = new ArrayList<>();
        final Book bookById = bookService.findBookById(bookId);
        if (bookById != null) {
            comments = bookById.getComment();
        }
        return comments;
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


