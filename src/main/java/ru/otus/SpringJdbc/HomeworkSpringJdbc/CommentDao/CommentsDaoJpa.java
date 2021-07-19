package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class CommentsDaoJpa implements CommentDao {
    @PersistenceContext
    private EntityManager em;

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

    @Override
    public void deleteCommentByBookId(Long bookId) {
        TypedQuery<Book> query = em.createQuery("select b from Book b where  b.id =:bookId", Book.class);
        query.setParameter("bookId", bookId);
        final List<Comment> comment = query.getSingleResult().getComment();
        for (Comment commentItem : comment) {
            if (commentItem.getId() != 0) {
                em.remove(commentItem);

            }
        }
    }
}
