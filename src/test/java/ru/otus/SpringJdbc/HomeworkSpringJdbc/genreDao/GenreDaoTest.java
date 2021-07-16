package ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

@DataJpaTest
class GenreDaoTest {

    Genre testGenre = new Genre((long) 2, "Non-fiction");
    @Autowired
    private TestEntityManager em;

    @Autowired
    GenreDao genreDao;

    @BeforeEach
    void setUp() {
        genreDao.save(testGenre);
    }

    @DirtiesContext
    @Test
    void insert() {
        val allGenre = genreDao.findAll();
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
        val genreByName = genreDao.getByName(testGenre.getName());
        Assertions.assertTrue(genreByName.contains(testGenre), "Не удалось найти жанр по  указанному названию");
    }

    @DirtiesContext
    @Test
    void getById() {
        val byId = genreDao.getById(testGenre.getId());
        Assertions.assertEquals(byId.getId(), testGenre.getId(), "Не удалось найти жанр по  указанному id");
    }

    @DirtiesContext
    @Test
    void deleteById() {
        genreDao.deleteById(testGenre.getId());
        Assertions.assertNull(em.find(Genre.class, testGenre.getId()), "Не удалось удалить жанр по указанному id");
    }
}