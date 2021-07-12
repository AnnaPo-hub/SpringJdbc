package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Value
@AllArgsConstructor
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    Long id;
    @Column (name = "date")
    LocalDate date;
    @Column(name = "comment")
    String comment;
}
