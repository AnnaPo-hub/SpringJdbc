package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowCallbackHandler {
    @Override
    public void processRow(ResultSet resultSet) throws SQLException {

    }
}
