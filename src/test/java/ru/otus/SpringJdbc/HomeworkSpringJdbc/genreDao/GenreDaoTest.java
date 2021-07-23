package ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.AuthorDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.CommentDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.GenreDao;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@Import({BookDao.class, CommentDao.class, GenreDao.class, AuthorDao.class})
class GenreDaoTest {

    Genre testGenre = new Genre((long) 2, "Non-fiction");
    @Autowired
    GenreDao genreDao;
    @Autowired
    private TestEntityManager em;

    @BeforeEach
    void setUp() {
        genreDao.insert(testGenre);
    }

    @DirtiesContext
    @Test
    void insert() {
        final List<Genre> allGenre = genreDao.findAll();
        Assertions.assertTrue(allGenre.contains(testGenre), "не удалось внести в БД указанный жанр");
    }

    @DirtiesContext
    @Test
    void getAll() {
        Assertions.assertEquals(2, genreDao.findAll().size(), "Ожидаемое и фактического количество жанров не соответствует");
    }

    @DirtiesContext
    @Test
    void getByName() {
        final List<Genre> genreByName = genreDao.getByName(testGenre.getName());
        Assertions.assertTrue(genreByName.contains(testGenre), "Не удалось найти жанр по  указанному названию");
    }

    @DirtiesContext
    @Test
    void getById() {
        final Optional<Genre> genreById = genreDao.getById(testGenre.getId());
        Assertions.assertTrue(genreById.isPresent(), "Не удалось найти жанр по  указанному id");
    }

    @DirtiesContext
    @Test
    void deleteById() {
        genreDao.deleteById(testGenre.getId());
        Assertions.assertNull(em.find(Genre.class, testGenre.getId()), "Не удалось удалить жанр по указанному id");
    }
}