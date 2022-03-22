package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author insert(Author author);

    List<Author> getAll();

    List<Author> getByName(String authorName);

    Optional<Author> getById(Long id);

    void deleteById(Long id);
}
