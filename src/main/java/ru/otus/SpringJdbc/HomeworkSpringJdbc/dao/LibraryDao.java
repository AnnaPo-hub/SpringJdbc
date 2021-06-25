package ru.otus.SpringJdbc.HomeworkSpringJdbc.dao;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.BookBo;

import java.util.List;

public interface LibraryDao {
    List<BookBo> getAll();
//    Book getBookByName(String bookName);
//
//    Book getBookByAuthor(String authorName);
//
//    Book getBookByGenre(String genre);
//    Book getBookById(String id);

    int insertBook(BookBo bookBo);

//    void deleteBookById(String id);
//
//    void updateBook(String itemToUpdate, String newValue);
}
