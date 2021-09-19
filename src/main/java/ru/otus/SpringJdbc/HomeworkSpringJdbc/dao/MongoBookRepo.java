package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.MongoBook;

import java.util.List;

public interface MongoBookRepo extends MongoRepository<MongoBook, String> {
    List<MongoBook> getByName(String bookName);

    @Query(value = "{'genre_id.name': ?0}", fields = "{'name': 1, 'author_id.name': 1,'author_id._id': 1, 'genre_id.name': 1, 'genre_id._id': 1}")
    List<MongoBook> getByGenre(String genre);

    MongoBook getById(Long id);

    void deleteById(Long id);

    @Query(value = "{'author_id.name': ?0}", fields = "{'name': 1, 'author_id.name': 1, 'author_id._id': 1, 'genre_id.name': 1,  'genre_id._id': 1}")
    List<MongoBook> findBookByAuthor(String author);
}
