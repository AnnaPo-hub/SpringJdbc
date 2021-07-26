//package ru.otus.SpringJdbc.HomeworkSpringJdbc.mongock;
//
//import com.github.cloudyrock.mongock.ChangeLog;
//import com.github.cloudyrock.mongock.ChangeSet;
//import com.mongodb.client.MongoDatabase;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.AuthorDao;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookDao;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.GenreDao;
//
//@ChangeLog
//public class DatabaseChangelog {
//    @ChangeSet(order = "001", id = "dropDb", author = "AnnaP", runAlways = true)
//    public void dropDb(MongoDatabase db) {
//        db.drop();
//    }
//
//    @ChangeSet(order = "002", id = "add-authors", author = "AnnaP")
//    public void addAuthor(AuthorDao authorDao) {
//        authorDao.deleteAll();
//        authorDao.save(new Author("Pushkin", null));
//        authorDao.save(new Author("Lermontov", null));
//    }
//
//    @ChangeSet(order = "003", id = "add-genres", author = "AnnaP")
//    public void addGenre(GenreDao genreDao) {
//        genreDao.deleteAll();
//        genreDao.save(new Genre( "Fiction"));
//        genreDao.save(new Genre( "Poetry"));
//    }
//
//    @ChangeSet(order = "004", id = "add-books", author = "AnnaP")
//    public void addBook(BookDao bookDao) {
//        bookDao.deleteAll();
//        bookDao.save(new Book("The wind",  new Author( "Pushkin"), new Genre( "Fiction")));
//        bookDao.save(new Book("The wind ",  new Author("Lermontov"), new Genre( "Poetry")));
//    }
//}
