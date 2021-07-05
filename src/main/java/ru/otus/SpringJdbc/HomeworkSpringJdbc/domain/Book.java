package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.*;

@Entity
@Value
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Author.class)
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Genre.class)
    @JoinColumn(name = "genre_id")
    Genre genre;
}
