package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "author")
public class Author {
    @Id
    private Long id;

    @Field(name = "name")
    private String name;

    @Field(name = "books")
    private List<Book> books;

    public Author (Long id, String name, Book... books){
        this.id=id;
        this.name= name;
        this.books = Arrays.asList(books);
    }
}
