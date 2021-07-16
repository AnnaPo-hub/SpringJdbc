package ru.otus.SpringJdbc.HomeworkSpringJdbc.authorDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;

import java.util.List;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {
    List<Author> getByName(String authorName);
}
