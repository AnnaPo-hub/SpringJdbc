package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue
    Long id;

    @Column(name = "date")
    LocalDate date;

    @Column(name = "comment_text")
    String comment_text;

    @Column(name = "author")
    String author;

    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_book_id"), nullable = false)
    private Book book;
}
