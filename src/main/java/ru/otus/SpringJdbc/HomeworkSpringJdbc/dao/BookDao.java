package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {

    List<Book> getByName(String bookName);

    List<Book> getByAuthor(Author author);

    List<Book> getByGenreName(String genre);
}

