package ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentsJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao.LibraryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({LibraryRepository.class, CommentsJpa.class, GenreDaoJpa.class, AuthorDaoJpa.class})
class AuthorDaoJpaTest {
    @Autowired
    private AuthorDaoJpa authorDaoJpa;

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private TestEntityManager em;

    Author testAuthor = new Author((long) 3, "Lermontov");

    @Test
    void insert() {
        authorDaoJpa.insert(testAuthor);
        final List<Author> allAuthors = authorDaoJpa.getAll();
        Assertions.assertTrue(allAuthors.contains(testAuthor), "Внесенный автор не содержится в списке всех авторов");
    }

    @Test
    void getAll() {
        final List<Author> allAuthors = authorDaoJpa.getAll();
        assertEquals(2, allAuthors.size(), "Общее количество авторов не соответствует ожидаемому");
    }

    @Test
    void getByName() {
        authorDaoJpa.insert(testAuthor);
        final List<Author> authorbyName = authorDaoJpa.getByName(testAuthor.getName());
        Assertions.assertTrue(authorbyName.contains(testAuthor), "Не получилось найти автора по имени");
    }

    @Test
    void getById() {
        authorDaoJpa.insert(testAuthor);
        final Optional<Author> byId = authorDaoJpa.getById(testAuthor.getId());
        Assertions.assertTrue(byId.isPresent(), "Не получилось найти автора по id");
    }

    @Test
    void deleteById() {
        authorDaoJpa.insert(testAuthor);
        authorDaoJpa.deleteById(testAuthor.getId());
        Assertions.assertNull(em.find(Author.class, (long) 3), "Элемент с указанным id не удален из БД");
    }
}