package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface BookDao extends MongoRepository<Book, String> {

    List<Book> getByName(String bookName);

    List<Book> getByGenre(String genre);

    Book getById(Long id);

    void deleteById(Long id);
}
