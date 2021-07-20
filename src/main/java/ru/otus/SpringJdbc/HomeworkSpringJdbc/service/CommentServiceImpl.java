package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;
    private final BookService bookService;

    @Override
    public List<Comment> getByBookId(long bookId) {
        List<Comment> comments = new ArrayList<>();
        final Optional<Book> bookById = bookService.findBookById(bookId);
        if (bookById.isPresent()) {
            comments = bookById.get().getComment();

        }
        return comments;
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
