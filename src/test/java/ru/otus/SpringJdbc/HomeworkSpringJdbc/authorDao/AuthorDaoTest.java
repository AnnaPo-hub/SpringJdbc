package ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.AuthorDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class AuthorDaoTest {
    private static Author testAuthor;

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private TestEntityManager em;

    @BeforeEach
    void setUp() {
        testAuthor = new Author((long) 3, "Lermontov");
        authorDao.save(testAuthor);
    }

    @DirtiesContext
    @Test
    public void insert() {
        final List<Author> allAuthors = authorDao.findAll();
        Assertions.assertTrue(allAuthors.contains(testAuthor), "Внесенный автор не содержится в списке всех авторов");
    }

    @DirtiesContext
    @Test
    public void getAll() {
        final List<Author> allAuthors = authorDao.findAll();
        assertEquals(3, allAuthors.size(), "Общее количество авторов не соответствует ожидаемому");
    }

    @DirtiesContext
    @Test
    public void getByName() {
        final List<Author> authorByName = authorDao.getByName(testAuthor.getName());
        Assertions.assertTrue(authorByName.contains(testAuthor), "Не получилось найти автора по имени");
    }

    @DirtiesContext
    @Test
    public void getById() {
        final Optional<Author> byId = authorDao.findById(testAuthor.getId());
        Assertions.assertTrue(byId.isPresent(), "Не получилось найти автора по id");
    }

    @DirtiesContext
    @Test
    public void deleteById() {
        authorDao.deleteById(testAuthor.getId());
        Assertions.assertNull(em.find(Author.class, testAuthor.getId()), "Элемент с указанным id не удален из БД");
    }
}
