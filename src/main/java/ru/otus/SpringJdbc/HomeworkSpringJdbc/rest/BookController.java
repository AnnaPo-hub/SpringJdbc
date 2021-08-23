package ru.otus.SpringJdbc.HomeworkSpringJdbc.rest;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.rest.dto.BookDto;

@AllArgsConstructor
@RestController
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/api/book")
    public Flux<BookDto> getAllBooks() {
        return bookRepository.findAll().map(BookDto::toDto);
    }

    @GetMapping("/api/book/{id}")
    public Mono<Book> getById(@PathVariable("id") long id) {
        return bookRepository.getById(id);
    }

    @PostMapping("/api/book")
    public Mono<Book>add(@RequestBody Mono<Book> book) {
        return  bookRepository.save(book);
    }

    @DeleteMapping("/api/book/{id}")
    public void delete(@PathVariable("id") long id) {
        bookRepository.deleteById(id);
    }
}
