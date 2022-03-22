package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

public interface BookDao extends MongoRepository<Book, String> {
    List<Book> getByName(String bookName);

    @Query(value = "{'genre_id.name': ?0}", fields = "{'name': 1, 'author_id.name': 1,'author_id._id': 1, 'genre_id.name': 1, 'genre_id._id': 1}")
    List<Book> getByGenre(String genre);

    Book getById(Long id);

    void deleteById(Long id);

    @Query(value = "{'author_id.name': ?0}", fields = "{'name': 1, 'author_id.name': 1, 'author_id._id': 1, 'genre_id.name': 1,  'genre_id._id': 1}")
    List<Book> findBookByAuthor(String author);
}
