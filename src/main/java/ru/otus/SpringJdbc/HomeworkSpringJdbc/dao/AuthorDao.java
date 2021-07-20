package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

import java.util.List;

@Component
public interface AuthorDao extends JpaRepository<Author, Long> {
    List<Author> getByName(String authorName);
}
