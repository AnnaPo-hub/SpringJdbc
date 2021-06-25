package ru.otus.SpringJdbc.HomeworkSpringJdbc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.dao.LibraryDao;
import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.BookBo;

import java.util.List;

@SpringBootApplication
public class HomeworkSpringJdbcApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(HomeworkSpringJdbcApplication.class, args);


       LibraryDao service = context.getBean(LibraryDao.class);
       service.insertBook(new BookBo(2, "Bluck", "The Wind", "poetry"));
        final List<BookBo> all = service.getAll();
        System.out.println("все книги в библиотеке: " + all.size());
        for(BookBo book : all){
            System.out.println(book);
            System.out.println();
        }


    }
}
