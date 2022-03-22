package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorDao extends MongoRepository<Author, String> {

    List<Author> getByName(String authorName);

    Optional<Author> getById(Long id);

    void deleteById(Long id);
}
