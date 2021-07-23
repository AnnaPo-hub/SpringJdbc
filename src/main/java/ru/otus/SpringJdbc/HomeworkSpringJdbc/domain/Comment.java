package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "comment")
public class Comment {
    @Id
    private Long id;

    @Field(name = "date")
    private LocalDate date;

    @Field(name = "comment_text")
    private String comment_text;

    @Field(name = "author")
    private String author;

    @Field(name = "book_id")
    private Book book;
}
