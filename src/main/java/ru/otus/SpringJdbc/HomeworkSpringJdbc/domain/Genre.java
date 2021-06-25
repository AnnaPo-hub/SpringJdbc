package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Genre {
    int id;
    String name;
}
