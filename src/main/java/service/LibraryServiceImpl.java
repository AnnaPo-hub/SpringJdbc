package service;

import domain.Book;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Override
    public Book findBookByName(String bookName) {
        return null;
    }

    @Override
    public Book findBookByAuthor(String authorName) {
        return null;
    }

    @Override
    public Book findBookByGenre(String genre) {
        return null;
    }

    @Override
    public void createBook(Book book) {

    }

    @Override
    public void deleteBookById(String id) {

    }

    @Override
    public void updateBook(String itemToUpdate, String newValue) {

    }
}
