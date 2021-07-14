package ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class GenreDaoJpa implements GenreDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre insert(Genre genre) {
        if (genre.getId() == 0) {
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    @Override
    public List<Genre> getAll() {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g", Genre.class);
        return query.getResultList();
    }

    @Override
    public List<Genre> getByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select g from Genre g where g.name=:name", Genre.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Optional<Genre> getById(Long id) {
        return Optional.ofNullable(em.find(Genre.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Query query = em.createQuery("delete from Genre g where g.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
