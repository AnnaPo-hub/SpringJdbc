package ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.AbstractRepositoryTest;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.AuthorDao;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AuthorDaoTest  extends AbstractRepositoryTest {
    private static Author testAuthor;

    @Autowired
    private AuthorDao authorDao;

    @BeforeEach
    void setUp() {
        testAuthor = new Author((long) 3, "Lermontov");
        authorDao.insert(testAuthor);
    }

    @Test
    public void insert() {
        final List<Author> allAuthors = authorDao.findAll();
        Assertions.assertTrue(allAuthors.contains(testAuthor), "Внесенный автор не содержится в списке всех авторов");
    }

    @Test
    public void getAll() {
        final List<Author> allAuthors = authorDao.findAll();
        assertEquals(1, allAuthors.size(), "Общее количество авторов не соответствует ожидаемому");
    }

    @Test
    public void getByName() {
        final List<Author> authorbyName = authorDao.getByName(testAuthor.getName());
        Assertions.assertTrue(authorbyName.contains(testAuthor), "Не получилось найти автора по имени");
    }

    @Test
    public void getById() {
        final Optional<Author> byId = authorDao.getById(testAuthor.getId());
        Assertions.assertTrue(byId.isPresent(), "Не получилось найти автора по id");
    }

    @Test
    public void deleteById() {
        authorDao.deleteById(testAuthor.getId());
        Assertions.assertEquals(Optional.empty(),authorDao.getById(testAuthor.getId()), "Элемент с указанным id не удален из БД");
    }
}
