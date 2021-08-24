package ru.otus.SpringJdbc.HomeworkSpringJdbc.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String id;
    private String name;
    private String author;
    private String genre;

    public static BookDto toDto(Book book) {
        return new BookDto(book.getId(), book.getName(), book.getName(), book.getGenre());
    }

    public Book toBook() {
        return new Book(id, name, author, genre);
    }

}
