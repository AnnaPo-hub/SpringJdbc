package ru.otus.SpringJdbc.HomeworkSpringJdbc.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookDao;

@AllArgsConstructor
@RestController
public class BookController {
    private final BookDao bookDao;

    @GetMapping("/api/book")
    public Flux<Book> getAllBooks() {
        return bookDao.findAll();
    }

    @GetMapping("/api/book/{id}")
    public Mono<Book> getById(@PathVariable("id") long id) {
        return bookDao.getById(id);
    }

    @PostMapping("/api/book")
    public Mono<Book>add(@RequestBody Mono<Book> book) {
        return  bookDao.save(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void delete(@PathVariable("id") long id) {
        bookDao.deleteById(id);
    }
}
