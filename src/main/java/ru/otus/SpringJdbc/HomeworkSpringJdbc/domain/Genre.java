package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@Value
@RequiredArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long genreId;
    @Column(name = "genre_name")
    String name;
}
