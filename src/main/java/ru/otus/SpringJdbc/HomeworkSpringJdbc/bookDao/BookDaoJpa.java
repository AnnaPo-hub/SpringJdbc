package ru.otus.SpringJdbc.HomeworkSpringJdbc.bookDao;


import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class BookDaoJpa implements BookDao {
    @PersistenceContext
    private EntityManager em;

    public BookDaoJpa(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Book insertBook(Book book) {
        if (book.getId() == 0) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    @Override
    public List<Book> getBookByName(String name) {
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.name=:name", Book.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Book> getBookByGenre(String genre) {
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.genre=(select g.id from Genre g where g.name = :genre)", Book.class);
        query.setParameter("genre", genre);
        return query.getResultList();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public void deleteBookById(Long id) {
        val book = getBookById(id);
        if (book.isPresent()) {
            em.remove(book.get());
        }
    }
}



