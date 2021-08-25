package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
