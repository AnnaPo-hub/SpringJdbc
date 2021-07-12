package ru.otus.SpringJdbc.HomeworkSpringJdbc.utils;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.HashMap;
import java.util.Map;

public class DbUtils {
    public final NamedParameterJdbcOperations jdbc;

    public DbUtils(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод ищет автора в таблице авторов по имени @param authorName
     *
     * @return id автора, если автор найден или null, если  автор не найден
     */

    public static Long findAuthor(NamedParameterJdbcOperations jdbc, String authorName) {
        Map<String, String> params = new HashMap<>();
        params.put("authorName", authorName);
        final Author author;
        try {
            author = jdbc.queryForObject("select a.id, a.name  from authors a where a.name =:authorName", params, new Mappers.AuthorMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return author.getId();
    }


    public static Long findGenre(NamedParameterJdbcOperations jdbc, String genreName) {
        Map<String, String> params = new HashMap<>();
        params.put("genreName", genreName);
        final Genre genre;
        try {
            genre = jdbc.queryForObject("select g.id, g.name  from genres g where g.name =:genreName", params, new Mappers.GenreMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return genre.getId();
    }
}
