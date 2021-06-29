package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.Value;

@Value
public class Book {
    Long id;
    String name;
    Author author;
    Genre genre;
}
