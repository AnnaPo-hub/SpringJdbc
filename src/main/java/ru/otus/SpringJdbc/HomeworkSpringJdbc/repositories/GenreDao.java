package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao extends MongoRepository<Genre, String> {

    List<Genre> getByName(String genreName);

    Optional<Genre> getById(Long id);

    void deleteById(Long id);
}
