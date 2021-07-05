package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkSpringJdbcApplication {

    public static void main(String[] args) throws SQLException {

        final ConfigurableApplicationContext context = SpringApplication.run(HomeworkSpringJdbcApplication.class, args);


    }
}

