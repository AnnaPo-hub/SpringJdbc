package ru.otus.SpringJdbc.HomeworkSpringJdbc.config;


import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.BookDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;

@Component
@JobScope
public class BookReader extends JpaPagingItemReader<Book> {

    private final BookDao bookRepository;

    @Autowired
    public BookReader( final BookDao bookRepository){
        super();
        this.bookRepository = bookRepository;
    }
}
