package ru.otus.SpringJdbc.HomeworkSpringJdbc.libraryDao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

import java.util.List;

@Repository
public interface BookDao extends JpaRepository<Book, Long> {
    //    List<Book> getAll();
//
    List<Book> getByName(String bookName);

    //  @Query("select b from Book b where b.author=(select a.id from Author a where a.name = :name")
    List<Book> getByAuthorName(String name);

    List<Book> getByGenreName(String genre);
//
//    Optional<Book> getBookById(Long id);
//
//    Book insertBook(Book book);
//
//    void deleteBookById(Long id);
}
