package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoGenre;

import java.util.List;
import java.util.Optional;

public interface MongoGenreRepo  extends MongoRepository<MongoGenre, String> {
    List<MongoGenre> getByName(String genreName);

    Optional<MongoGenre> getById(Long id);

    void deleteById(Long id);
}
