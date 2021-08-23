package ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

public interface BookDao extends ReactiveMongoRepository<Book, String> {
    Flux<Book> findAll();

    Mono<Book> getById(Long id);

    Mono<Book> save(Mono<Book> book);

    Flux<Book> getByName(String bookName);

    @Query(value = "{'genre_id.name': ?0}", fields = "{'name': 1, 'author_id.name': 1,'author_id._id': 1, 'genre_id.name': 1, 'genre_id._id': 1}")
    Flux<Book> getByGenre(String genre);

    void deleteById(Long id);

    @Query(value = "{'author_id.name': ?0}", fields = "{'name': 1, 'author_id.name': 1, 'author_id._id': 1, 'genre_id.name': 1,  'genre_id._id': 1}")
    Flux<Book> findBookByAuthor(String author);
}
