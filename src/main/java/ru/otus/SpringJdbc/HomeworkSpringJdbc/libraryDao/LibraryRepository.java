package ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao;


import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class LibraryRepository implements LibraryDao {
    @PersistenceContext
    private EntityManager em;

    public LibraryRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }

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
    public List<Book> getBookByAuthor(String name) {
        TypedQuery<Book> query = em.createQuery("select b from Book b where b.author=(select a.id from Author a where a.name = :name)", Book.class);
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
        Query query = em.createQuery("delete from Book b where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}


