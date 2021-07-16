package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.List;

@Repository
public interface GenreDao extends JpaRepository<Genre, Long> {

    List<Genre> getByName(String genreName);
}
