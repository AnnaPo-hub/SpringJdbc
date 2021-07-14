package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao.GenreDao;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    GenreDao genreDao;

    @Transactional
    @Override
    public Genre insert(Genre genre) {
        return genreDao.insert(genre);
    }

    @Transactional
    @Override
    public List<Genre> getAll() {
        return genreDao.getAll();
    }

    @Transactional
    @Override
    public List<Genre> getByName(String genreName) {
        return genreDao.getByName(genreName);
    }

    @Transactional
    @Override
    public Optional<Genre> getById(Long id) {
        return genreDao.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        genreDao.deleteById(id);

    }
}
