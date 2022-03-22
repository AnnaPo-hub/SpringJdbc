package ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.AbstractRepositoryTest;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.GenreDao;

import java.util.List;
import java.util.Optional;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class GenreDaoTest extends AbstractRepositoryTest {
    Genre testGenre = new Genre((long) 2, "Non-fiction");

    @Autowired
    GenreDao genreDao;


    @BeforeEach
    void setUp() {
        genreDao.insert(testGenre);
    }

    @Test
    void insert() {
        final List<Genre> allGenre = genreDao.findAll();
        Assertions.assertTrue(allGenre.contains(testGenre), "не удалось внести в БД указанный жанр");
    }

    @Test
    void getAll() {
        Assertions.assertEquals(1, genreDao.findAll().size(), "Ожидаемое и фактического количество жанров не соответствует");
    }

    @Test
    void getByName() {
        final List<Genre> genreByName = genreDao.getByName(testGenre.getName());
        Assertions.assertTrue(genreByName.contains(testGenre), "Не удалось найти жанр по  указанному названию");
    }

    @Test
    void getById() {
        final Optional<Genre> genreById = genreDao.getById(testGenre.getId());
        Assertions.assertTrue(genreById.isPresent(), "Не удалось найти жанр по  указанному id");
    }

    @Test
    void deleteById() {
        genreDao.deleteById(testGenre.getId());
        Assertions.assertEquals(Optional.empty(), genreDao.getById(testGenre.getId()), "Не удалось удалить жанр по указанному id");
    }
}
