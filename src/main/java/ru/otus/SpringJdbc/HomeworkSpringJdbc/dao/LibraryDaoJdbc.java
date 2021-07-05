package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.utils.DbUtils;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.utils.Mappers;

import java.util.*;

@Component
public class LibraryDaoJdbc implements LibraryDao {
    private final NamedParameterJdbcOperations jdbc;

    public LibraryDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Book> getAll() {
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id", new Mappers.BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public int insertBook(Book book) {
        return jdbc.update("insert into books(id, name, author_id, genre_id)values(:id, :name, :author_id,:genre_id)",
                Map.of("id", book.getId(), "name", book.getName(), "author_id", book.getAuthor().getAuthorId(),
                        "genre_id", book.getGenre().getGenreId()));
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("book_name", bookName);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where b.name =:book_name", parameters, new Mappers.BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public List<Book> getBookByAuthor(String authorName) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("author_name", authorName);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where a.name =:author_name", parameters, new Mappers.BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public List<Book> getBookByGenre(String genre) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("genre_name", genre);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where g.name =:genre_name", parameters, new Mappers.BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public Book getBookById(Long id) {
        Map<String, Long> parameters = new HashMap<>();
        parameters.put("book_id", id);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where b.id =:book_id", parameters, new Mappers.BookResultSetExtractor());
        return query.get(id);
    }

    @Override
    public int deleteBookById(Long id) {
        return jdbc.getJdbcOperations().update("Delete  FROM BOOKS b  where b.id=?", id);
    }

    @Override
    public void insertAuthor(String authorName, NamedParameterJdbcOperations jdbc) {
        if (DbUtils.findAuthor(jdbc, authorName) == null) {
            Map<String, String> params = new HashMap<>();
            params.put("authorName", authorName);
            jdbc.update("insert into authors (name) values (:authorName)", params);
        }
    }

    @Override
    public void insertGenre(String genreName, NamedParameterJdbcOperations jdbc) {
        if (DbUtils.findGenre(jdbc, genreName) == null) {
            Map<String, String> params = new HashMap<>();
            params.put("genreName", genreName);
            jdbc.update("insert into genres (name) values (:genreName)", params);
        }
    }
}



