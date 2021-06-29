package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Genre {
    Long genreId;
    String name;
}
