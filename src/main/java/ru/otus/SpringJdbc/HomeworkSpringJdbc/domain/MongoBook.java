package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "book")
public class MongoBook {
    @Id
    private Long id;

    @Field(name = "name")
    private String name;

    @Field(name = "author_id")
    private MongoAuthor author;

    @Field(name = "genre_id")
    private MongoGenre genre;
}
