package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;
    private final BookService bookService;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> getAllByBook(long bookId) {
        return commentDao.getAllByBook(bookId);
    }

    @Override
    public List<Comment> getCommentByBookId(long bookId) {
        List<Comment> comments = new ArrayList<>();
        final Book bookById = bookService.findBookById(bookId);
        Hibernate.initialize(bookById);
        if (bookById!=null) {
            comments = bookById.getComment();
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
    public Comment insertComment(Comment comment) {
        if (comment.getId() == 0) {
            if (comment.getBook().getComment() == null) {
                comment.getBook().setComment(new ArrayList<>());
            }
            comment.getBook().getComment().add(comment);
            em.persist(comment);
        } else {
            return em.merge(comment);
        }
        return comment;
    }
}
