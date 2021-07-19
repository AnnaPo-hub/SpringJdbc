package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    CommentDao commentDao;
    BookService bookService;

    @Transactional
    @Override
    public List<Comment> getCommentByBookId(long bookId) {
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
        commentDao.deleteCommentByBookId(id);
    }

    @Transactional
    @Override
    public void insertComment(Comment comment) {
        commentDao.insertComment(comment);
    }
}
