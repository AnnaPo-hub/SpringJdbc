package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.List;
import java.util.Optional;
@Service
public interface GenreService {
    Genre insert(Genre genre);

    List<Genre> getAll();

    List<Genre> getByName(String genreName);

    Optional<Genre> getById(Long id);

    void deleteById(Long id);
}
