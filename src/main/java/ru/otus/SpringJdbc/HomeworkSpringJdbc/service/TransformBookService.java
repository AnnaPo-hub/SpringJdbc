package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;

import org.springframework.stereotype.Service;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoAuthor;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoBook;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoGenre;

@Service
public class TransformBookService {
    public MongoBook makeMangoBookFromJpaBook(Book book){
        return MongoBook.builder()
                .id(book.getId())
                .name(book.getName())
                .author(new MongoAuthor(book.getAuthor().getId(),book.getAuthor().getName()))
                .genre(new MongoGenre(book.getGenre().getId(), book.getGenre().getName()))
                .build();
    }
}
