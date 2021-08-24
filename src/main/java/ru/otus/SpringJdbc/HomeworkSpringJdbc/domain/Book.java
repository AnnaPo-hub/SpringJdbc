package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "book")
public class Book {
    @Id
    @Field("_id")
    private String id;

    private String name;

    private String author;

    private String genre;
}
