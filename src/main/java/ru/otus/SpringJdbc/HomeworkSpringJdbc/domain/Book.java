package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Document(collection = "book")
public class Book {
    @Id
    private Long id;

    @Field(name = "name")
    private String name;

    @Field(name = "author_id")
    private Author author;

    @Field(name = "genre_id")
    private Genre genre;

    @Field(name = "comments")
    private List<Comment> comment;
}
