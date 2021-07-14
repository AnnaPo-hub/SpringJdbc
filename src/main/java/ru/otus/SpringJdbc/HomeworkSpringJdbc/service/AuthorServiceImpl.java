package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    AuthorDao authorDao;

    @Transactional
    @Override
    public Author insert(Author author) {
        return authorDao.insert(author);
    }

    @Transactional
    @Override
    public List<Author> getAll() {
        return authorDao.getAll();
    }

    @Transactional
    @Override
    public List<Author> getByName(String authorName) {
        return authorDao.getByName(authorName);
    }

    @Transactional
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