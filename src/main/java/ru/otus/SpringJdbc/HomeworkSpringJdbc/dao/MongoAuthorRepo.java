package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoAuthor;

import java.util.List;
import java.util.Optional;

@Component
public interface MongoAuthorRepo extends MongoRepository<MongoAuthor, String> {
    List<MongoAuthor> getByName(String authorName);

    Optional<MongoAuthor> getById(Long id);

    void deleteById(Long id);
}
