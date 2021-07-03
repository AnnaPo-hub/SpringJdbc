package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.Value;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Value
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "book_name")
    String name;
    Author author;
    @ManyToOne(cascade = CascadeType.ALL)
    Genre genre;
}
