package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.BookBo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
public class LibraryDaoJdbc implements LibraryDao {
    private final NamedParameterJdbcOperations jdbc;

    public LibraryDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<BookBo> getAll() {
        return jdbc.query("select* from books", new BookMapper());
    }

    @Override
    public int insertBook(BookBo book) {
        return jdbc.update("insert into books(id, author, name, genre)values(:id,:author,:name,:genre)",
                Map.of("id", book.getId(), "author", book.getAuthor(), "name", book.getName(), "genre", book.getGenre()));

    }

    private static class BookMapper implements RowMapper<BookBo> {
        @Override
        public BookBo mapRow(ResultSet resultSet, int i) throws SQLException {
            int id = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String name = resultSet.getString("name");
            String genre = resultSet.getString("genre");
            return new BookBo(id, author, name, genre);
        }

    }

//    @Override
//    public Book getBookByName(String bookName) {
//        return null;
//    }
//
//    @Override
//    public Book getBookByAuthor(String authorName) {
//        return null;
//    }
//
//    @Override
//    public Book getBookByGenre(String genre) {
//        return null;
//    }
//
//    @Override
//    public Book getBookById(String id) {
//        return null;
//    }
//
//
//    @Override
//    public void deleteBookById(String id) {
//
//    }
//
//    @Override
//    public void updateBook(String itemToUpdate, String newValue) {
//
//    }
}
