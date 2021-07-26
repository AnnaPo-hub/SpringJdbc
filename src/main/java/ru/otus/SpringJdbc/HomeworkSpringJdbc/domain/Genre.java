package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "genre")
public class Genre {
    @Id
    private Long id;

    @Field(name = "name")
    private String name;

}
