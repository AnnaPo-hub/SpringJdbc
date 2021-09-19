package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

@Component
public interface BookDao extends JpaRepository<Book, Long> {
    List<Book> getByName(String bookName);

    List<Book> getByGenreName(String genre);
}

