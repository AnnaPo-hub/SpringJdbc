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
        final Map<Long, Book> query = jdbc.query(" select b.id, b.book_name, a.author_name, a.id as author_id, g.genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id", new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public int insertBook(Book book) {
        return jdbc.update("insert into books(id, name, author_id, genre_id)values(:id, :name, :author_id,:genre_id)",
                Map.of("id", book.getId(), "name", book.getName(), "author_id", book.getAuthor().getId(),
                        "genre_id", book.getGenre().getId()));
    }

    @Override
    public List<Book> getBookByName(String bookName) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("book_name", bookName);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where b.name =:book_name", parameters, new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public List<Book> getBookByAuthor(String authorName) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("author_name", authorName);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where a.name =:author_name", parameters, new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public List<Book> getBookByGenre(String genre) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("genre_name", genre);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where g.name =:genre_name", parameters, new BookResultSetExtractor());
        return new ArrayList<>(Objects.requireNonNull(query.values()));
    }

    @Override
    public Book getBookById(Long id) {
        Map<String, Long> parameters = new HashMap<>();
        parameters.put("book_id", id);
        final Map<Long, Book> query = jdbc.query(" select b.id, b.name as book_name, a.name as author_name, a.id as author_id, g.name as genre_name, g.id as genre_id  from books b left join authors a on b.author_id=a.id " +
                "left join genres g on b.genre_id=g.id where b.id =:book_id", parameters, new BookResultSetExtractor());
        return query.get(id);
    }

    @Override
    public int deleteBookById(Long id) {
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
                book = new Book(id, rs.getString("book_name"),
                        new Author(rs.getLong("author_id"), rs.getString("author_name")),
                        new Genre(rs.getLong("genre_id"), rs.getString("genre_name")));
                books.put(book.getId(), book);
            }
        }
        return books;
    }
}



