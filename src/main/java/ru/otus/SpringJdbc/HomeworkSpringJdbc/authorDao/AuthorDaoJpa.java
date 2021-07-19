package ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class AuthorDaoJpa implements AuthorDao {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public Author insert(Author author) {
        if (author.getId() == 0) {
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    @Override
    public List<Author> getAll() {
        TypedQuery<Author> query = em.createQuery("select a from Author a", Author.class);
        return query.getResultList();
    }

    @Override
    public List<Author> getByName(String name) {
        TypedQuery<Author> query = em.createQuery("select a from Author a where a.name=:name", Author.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Optional<Author> getById(Long id) {
        return Optional.ofNullable(em.find(Author.class, id));
    }

    @Override
    public void deleteById(Long id) {
        val author = getById(id);
        if (author.isPresent()) {
            em.remove(author.get());
        }
    }
}
