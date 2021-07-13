package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

@Repository
@AllArgsConstructor
public class CommentsRepository implements CommentDao {
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

    @Override//ok
    public Comment getCommentByBookId(long bookId) {
        TypedQuery<Comment> query = em.createQuery("select c from Comment c where c.id = (select b.comment from Book b where b.id =:bookId)", Comment.class);
        query.setParameter("bookId", bookId);
        return query.getSingleResult();
    }

    @Override //работает
    public void deleteCommentByBookId(Long bookId) {
        Query query = em.createQuery("update Book b set b.comment = null where b.id= :bookId");
        //"delete b.comment from Book b where b.id = (select b.comment from Book b where b.id =:bookId)");
        query.setParameter("bookId", bookId);
        query.executeUpdate();
    }
}
