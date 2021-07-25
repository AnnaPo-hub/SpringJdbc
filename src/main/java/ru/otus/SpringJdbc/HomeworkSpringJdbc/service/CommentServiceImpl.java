package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dto.CommentDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> getAllByBook(long bookId) {
        return commentDao.getAllByBook(bookId);
    }

    @Override
    public List<CommentDto> getCommentByBookId(long bookId) {
        TypedQuery<CommentDto> q = em.createQuery(
                "SELECT new ru.otus.SpringJdbc.HomeworkSpringJdbc.dto.CommentDto(b.id, c.comment_text, c.author,c.date) FROM Book b  JOIN b.comment c where b.id =:bookId",
                CommentDto.class);
        q.setParameter("bookId", bookId);

        return q.getResultList();
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
