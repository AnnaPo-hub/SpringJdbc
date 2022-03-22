package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.AuthorDao;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorDao authorDao;

    @Transactional
    @Override
    public Author insert(Author author) {
        return authorDao.insert(author);
    }

    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Override
    public List<Author> getByName(String authorName) {
        return authorDao.getByName(authorName);
    }

    @Override
    public Optional<Author> getById(Long id) {
        return authorDao.getById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        authorDao.deleteById(id);
    }
}
