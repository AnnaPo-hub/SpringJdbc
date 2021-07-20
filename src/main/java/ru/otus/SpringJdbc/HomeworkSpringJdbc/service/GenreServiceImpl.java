package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.GenreDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreDao genreDao;

    @Transactional
    @Override
    public Genre insert(Genre genre) {
        return genreDao.save(genre);
    }


    @Override
    public List<Genre> getAll() {
        return genreDao.findAll();
    }


    @Override
    public List<Genre> getByName(String genreName) {
        return genreDao.getByName(genreName);
    }


    @Override
    public Optional<Genre> getById(Long id) {
        return genreDao.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        genreDao.deleteById(id);
    }
}
