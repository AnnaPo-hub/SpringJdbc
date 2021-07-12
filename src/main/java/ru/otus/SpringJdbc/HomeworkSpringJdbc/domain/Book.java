package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "name")
    String name;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Author.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Genre.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id")
    Genre genre;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Comment.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "comment_id",nullable = true)
    List<Comment> comments;

}
