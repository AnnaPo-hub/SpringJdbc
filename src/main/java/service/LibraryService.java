package service;

import domain.Book;

public interface LibraryService {
    Book findBookByName(String bookName);

    Book findBookByAuthor(String authorName);

    Book findBookByGenre(String genre);

    void createBook(Book book);

    void deleteBookById(String id);

    void updateBook(String itemToUpdate, String newValue);
}
