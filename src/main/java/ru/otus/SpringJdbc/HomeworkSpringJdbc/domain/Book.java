package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "book")
public class Book {
    @Id
    private Long id;

    @JsonProperty("name")
    @Field(name = "name")
    private String name;

    @JsonProperty("author")
    @Field(name = "author_id")
    private Author author;

    @JsonProperty("genre")
    @Field(name = "genre")
    private String genre;
}
