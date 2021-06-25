package ru.otus.SpringJdbc.HomeworkSpringJdbc.service;


import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.BookBo;

import java.util.List;

public interface LibraryService {
    void createBook(BookBo book);

    List<BookBo> showAllBooks();


//    Book findBookByName(String bookName);
//
//    Book findBookByAuthor(String authorName);
//
//    Book findBookByGenre(String genre);
//    void deleteBookById(String id);
//
//    void changeBookInfo(String itemToUpdate, String newValue);
}
