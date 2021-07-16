package ru.otus.SpringJdbc.HomeworkSpringJdbc.genreDao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.List;

@Repository
public interface GenreDao extends JpaRepository<Genre, Long> {
    //    Genre insert(Genre genre);
//
//    List<Genre> getAll();
//
    List<Genre> getByName(String genreName);
//
//    Optional<Genre> getById(Long id);
//
//    void deleteById(Long id);
}
