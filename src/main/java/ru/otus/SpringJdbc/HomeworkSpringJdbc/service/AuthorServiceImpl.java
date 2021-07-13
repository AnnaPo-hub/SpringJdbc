package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao.AuthorDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    AuthorDao authorDao;

    @Transactional
    @Override
    public Author insert(Author author) {
        return authorDao.insert(author);
    }
}
