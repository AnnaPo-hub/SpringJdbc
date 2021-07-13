package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDao;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    GenreDao genreDao;

    @Transactional
    @Override
    public Genre insert(Genre genre) {
        return genreDao.insert(genre);
    }
}
