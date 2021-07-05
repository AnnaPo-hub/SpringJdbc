package ru.otus.SpringJdbc.HomeworkSpringJdbc.utils;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.util.HashMap;
import java.util.Map;

public class DbUtils {
    public final  NamedParameterJdbcOperations jdbc;

    public DbUtils(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    /**
     * Метод ищет автора в таблице авторов по имени @param authorName
     *
     * @return сущность автор, если автор найден или null, если  автор не найден
     */

    public static Author findAuthor(NamedParameterJdbcOperations jdbc, String authorName) {
        Map<String, String> params = new HashMap<>();
        params.put("authorName", authorName);
        final Author author = jdbc.queryForObject("select a.id, a.name  from authors a where a.name =:authorName", params, new Mappers.AuthorMapper());
        return author;
    }




    public static Genre findGenre(NamedParameterJdbcOperations jdbc, String genreName) {
        Map<String, String> params = new HashMap<>();
        params.put("genreName", genreName);
        final Genre genre = jdbc.queryForObject("select g.id, g.name  from genres g where g.name =:genreName", params, new Mappers.GenreMapper());
        return genre;
    }


}
