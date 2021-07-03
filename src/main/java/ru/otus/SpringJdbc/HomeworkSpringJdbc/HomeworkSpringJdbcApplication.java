package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkSpringJdbcApplication {

    public static void main(String[] args) throws SQLException {

        SpringApplication.run(HomeworkSpringJdbcApplication.class, args);
        // Console.main(args);
    }
}
