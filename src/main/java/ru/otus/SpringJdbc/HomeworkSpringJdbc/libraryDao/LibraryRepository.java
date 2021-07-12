package ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao;


import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Component
public class LibraryRepository implements LibraryDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getAll() {
        TypedQuery<Book> query = em.createQuery("select b from books b", Book.class);
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
    public Optional<Book> getBookByName(String name) {
        return Optional.ofNullable(em.find(Book.class, name));
    }

    @Override
    public Optional<Book> getBookByAuthor(String authorName) {
        return Optional.ofNullable(em.find(Book.class, authorName));
    }

    @Override
    public Optional<Book> getBookByGenre(String genre) {
        return Optional.ofNullable(em.find(Book.class, genre));
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public void deleteBookById(Long id) {
        Query query = em.createQuery("delete from Books b where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}



