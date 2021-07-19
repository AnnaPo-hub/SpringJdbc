package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class HomeworkSpringApp {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(HomeworkSpringApp.class, args);

        Console.main(args);

    }
}
