package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CommentsRepository implements CommentDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Comment> getAll() {
        TypedQuery<Comment> query = em.createQuery("select c from comments c", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment insertComment(Comment comment) {
        if (comment.getId() == 0) {
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

    @Override
    public void deleteCommentById(Long id) {
        Query query = em.createQuery("delete from comments c where c.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}
