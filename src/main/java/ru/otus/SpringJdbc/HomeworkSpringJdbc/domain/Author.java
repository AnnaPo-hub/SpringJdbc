package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Value
@Entity
@AllArgsConstructor
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;
}
