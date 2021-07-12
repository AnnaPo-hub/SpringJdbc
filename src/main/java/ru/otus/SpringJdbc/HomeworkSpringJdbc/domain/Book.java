package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.util.List;

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

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    Genre genre;

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Comment.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id")
    List<Comment> comments;

}
