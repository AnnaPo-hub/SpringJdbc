package ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao;

import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        val genre = getById(id);
        if (genre.isPresent()) {
            em.remove(genre.get());
        }
    }
}
