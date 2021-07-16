package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.AuthorDao;
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
        return authorDao.save(author);
    }

    @Transactional
    @Override
    public List<Author> getAll() {
        return authorDao.findAll();
    }

    @Transactional
    @Override
    public List<Author> getByName(String authorName) {
        return authorDao.getByName(authorName);
    }

    @Transactional
    @Override
    public Optional<Author> getById(Long id) {
        return authorDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        authorDao.deleteById(id);
    }
}
