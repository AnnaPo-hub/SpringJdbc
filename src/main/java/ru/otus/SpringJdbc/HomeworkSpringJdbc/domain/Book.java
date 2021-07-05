package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Book {
    Long id;
    String name;
    Author author;
    Genre genre;
}
