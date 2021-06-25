package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class LibraryDaoJdbc implements LibraryDao {
    private final NamedParameterJdbcOperations jdbc;

    public LibraryDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Book> getAll() {
        return jdbc.query("select* from books", new BookMapper());
    }

    @Override
    public int insertBook(Book book) {
        return jdbc.update("insert into books(id, author, name, genre)values(:id,:author,:name,:genre)",
                Map.of("id", book.getId(), "author", book.getAuthor(), "name", book.getName(), "genre", book.getGenre()));

    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String name = resultSet.getString("name");
            String genre = resultSet.getString("genre");
            return new Book(id, author, name, genre);
        }

    }

    @Override
    public Book getBookByName(String bookName) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("name", bookName);
        return jdbc.queryForObject(" SELECT id, author, name,genre  FROM BOOKS b  where b.name=:bookName", params, new BookMapper());
    }

    @Override
    public Book getBookByAuthor(String authorName) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("author", authorName);
        return jdbc.queryForObject(" SELECT id, author, name,genre  FROM BOOKS b  where b.author=:authorName", params, new BookMapper());
    }

    @Override
    public Book getBookByGenre(String genre) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("genre", genre);
        return jdbc.queryForObject(" SELECT id, author, name,genre  FROM BOOKS b  where b.genre=:genre", params, new BookMapper());
    }

    @Override
    public Book getBookById(String id) {
        final Map<String, Object> params = new HashMap<>(1);
        params.put("bookId", id);
        return jdbc.queryForObject(" SELECT id, author, name,genre  FROM BOOKS b  where b.id=:id", params, new BookMapper());
    }


    @Override
    public int deleteBookById(String id) {
        return jdbc.getJdbcOperations().update("Delete  FROM BOOKS b  where b.id=?", id);

    }
}
