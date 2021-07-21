package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@AllArgsConstructor
public class CommentsDaoJpa implements CommentDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> getAllByBook(Long bookId) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.book.id =:bookId", Comment.class);
        query.setParameter("bookId", bookId);
        return query.getResultList();
    }

    @Override
    public void deleteCommentByBookId(Long bookId) {
        final Query query = em.createQuery("delete from Comment c where c.book.id = :bookId");
        query.setParameter("bookId", bookId);
        query.executeUpdate();
    }
}

