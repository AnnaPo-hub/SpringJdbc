package ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao.CommentsDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.bookDao.BookDaoJpa;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@Import({BookDaoJpa.class, CommentsDaoJpa.class, GenreDaoJpa.class, AuthorDaoJpa.class})
class GenreDaoJpaTest {

    Genre testGenre = new Genre((long) 2, "Non-fiction");
    @Autowired
    GenreDaoJpa genreDaoJpa;
    @Autowired
    private TestEntityManager em;

    @BeforeEach
    void setUp() {
        genreDaoJpa.insert(testGenre);
    }

    @DirtiesContext
    @Test
    void insert() {
        final List<Genre> allGenre = genreDaoJpa.getAll();
        Assertions.assertTrue(allGenre.contains(testGenre), "не удалось внести в БД указанный жанр");
    }

    @DirtiesContext
    @Test
    void getAll() {
        Assertions.assertEquals(2, genreDaoJpa.getAll().size(), "Ожидаемое и фактического количество жанров не соответствует");
    }

    @DirtiesContext
    @Test
    void getByName() {
        final List<Genre> genreByName = genreDaoJpa.getByName(testGenre.getName());
        Assertions.assertTrue(genreByName.contains(testGenre), "Не удалось найти жанр по  указанному названию");
    }

    @DirtiesContext
    @Test
    void getById() {
        final Optional<Genre> genreById = genreDaoJpa.getById(testGenre.getId());
        Assertions.assertTrue(genreById.isPresent(), "Не удалось найти жанр по  указанному id");
    }

    @DirtiesContext
    @Test
    void deleteById() {
        genreDaoJpa.deleteById(testGenre.getId());
        Assertions.assertNull(em.find(Genre.class, testGenre.getId()), "Не удалось удалить жанр по указанному id");
    }
}