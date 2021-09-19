package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoBook;

@Service
public class TransformBookService {
    public MongoBook makeMangoBookFromJpaBook(Book book){
        return MongoBook.builder()
                .id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .genre(book.getGenre())
                .build();
    }
}
