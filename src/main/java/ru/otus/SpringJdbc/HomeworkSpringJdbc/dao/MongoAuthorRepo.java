package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoAuthor;

import java.util.List;
import java.util.Optional;

public interface MongoAuthorRepo extends MongoRepository<MongoAuthor, String> {
    List<MongoAuthor> getByName(String authorName);

    Optional<MongoAuthor> getById(Long id);

    void deleteById(Long id);
}
