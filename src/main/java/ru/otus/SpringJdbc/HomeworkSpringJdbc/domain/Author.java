package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Entity
@Table(name = "author")
@Value
@RequiredArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long authorId;
    @Column(name = "author_name")
    String name;
}
