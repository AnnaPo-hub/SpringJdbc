package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class LibraryDaoJdbc implements LibraryDao {
    private final NamedParameterJdbcOperations jdbc;

    public LibraryDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Book> getAll() {
        final Map<Long, Book> query = jdbc.query(" select b.id, b. name, a.name,g.name  from(books b left join authors a on b.author_id=a.id) " +
                "left join genres g on b.genre_id=g.id", new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public int insertBook(Book book) {
        return jdbc.update("insert into books(id, author, name, genre)values(:id,:author,:name,:genre)",
                Map.of("id", book.getId(), "author", book.getAuthor(), "name", book.getName(), "genre", book.getGenre()));

    }

    @Override
    public List<Book> getBookByName(String bookName) {
        final Map<Long, Book> query = jdbc.query(" select b.id, b. name, a.name,g.name  from(books b left join authors a on b.author_id=a.id) " +
                "left join genres g on b.genre_id=g.id where b.name=:bookName", new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public List<Book> getBookByAuthor(String authorName) {
        final Map<Long, Book> query = jdbc.query(" select b.id, b. name, a.name,g.name  from(books b left join authors a on b.author_id=a.id) " +
                "left join genres g on b.genre_id=g.id where a.name=:authorName", new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public List<Book> getBookByGenre(String genre) {
        final Map<Long, Book> query = jdbc.query(" select b.id, b. name, a.name,g.name  from(books b left join authors a on b.author_id=a.id) " +
                "left join genres g on b.genre_id=g.id where g.name=:genre", new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }


//    @Override
//    public Book getBookById(String id) {
//        final Map<Long, Book> query = jdbc.query(" select b.id, b. name, a.name,g.name  from(books b left join authors a on b.author_id=a.id) " +
//                "left join genres g on b.genre_id=g.id where g.name=:genre", new BookResultSetExtractor());
//        return new ArrayList<>(Objects.requireNonNull(query.values()));
//    }


    @Override
    public int deleteBookById(String id) {
        return jdbc.getJdbcOperations().update("Delete  FROM BOOKS b  where b.id=?", id);

    }
}

class BookResultSetExtractor implements ResultSetExtractor<Map<Long, Book>> {
    @Override
    public Map<Long, Book> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Long, Book> books = new HashMap<>();
        while (rs.next()) {
            long id = rs.getLong("id");
            Book book = books.get(id);
            if (book == null) {
                book = new Book(id, rs.getString("name"),
                        new Author(rs.getLong("authorId"), rs.getString("name")),
                        new Genre(rs.getLong("genreId"), rs.getString("name")));
                books.put(book.getId(), book);
            }
        }
        return books;
    }
}


//class BookMapper implements RowMapper<Book> {
//    @Override
//    public Book mapRow(ResultSet resultSet, int i) throws SQLException {
//        int id = resultSet.getInt("id");
//        String author = resultSet.getString("author");
//        String name = resultSet.getString("name");
//        String genre = resultSet.getString("genre");
//        return new Book(id, author, name, genre);
//    }


