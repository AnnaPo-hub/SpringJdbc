package ru.otus.SpringJdbc.HomeworkSpringJdbc.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookRepository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.rest.dto.BookDto;

@RequiredArgsConstructor
@RestController
public class BookController {
    private final BookRepository bookRepository;

    @GetMapping("/api/book")
    public Flux<BookDto> getAllBooks() {
        return bookRepository.findAll().map(BookDto::toDto);
    }

    @GetMapping("/api/book/{id}")
    public Mono<Book> getById(@PathVariable("id") String id) {
        return bookRepository.findById(id);
    }

    @PostMapping("/api/book")
    public Mono<Book> add(@RequestBody BookDto book) {
        return bookRepository.save(book.toBook());
    }

    @DeleteMapping("/api/book/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return bookRepository.deleteById(id);
    }
}
