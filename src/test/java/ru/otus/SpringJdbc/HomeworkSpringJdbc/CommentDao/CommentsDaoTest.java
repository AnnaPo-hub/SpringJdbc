//package ru.otus.SpringJdbc.HomeworkSpringJdbc.CommentDao;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.context.annotation.Import;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.transaction.annotation.Transactional;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Author;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Book;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Comment;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.domain.Genre;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.AuthorDao;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.BookDao;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.CommentDao;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.repositories.GenreDao;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.BookServiceImpl;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.CommentService;
//import ru.otus.SpringJdbc.HomeworkSpringJdbc.service.CommentServiceImpl;
//
//import java.time.LocalDate;
//import java.util.List;
//
//
//class CommentsDaoJpaTest {
//    private final Genre genre = new Genre((long) 1, "Poetry");
//    private Author author = new Author((long) 1, "Blok", null);
//    private Book testbook = new Book((long) 3, "BookforInsertCommentTest", author, genre, null);
//    private final Comment testComment = new Comment((long) 2, LocalDate.now(), "Must read", "Vasya", testbook);
//    private Comment insertedComment;
//
//    @Autowired
//    private CommentDao commentsDaoJpa;
//
//    @Autowired
//    private BookDao libraryRepository;
//
//
//    @Autowired
//    private CommentService commentService;
//
//    @BeforeEach
//    void setUp() {
//        libraryRepository.insert(testbook);
//        insertedComment = commentService.insert(testComment);
//    }
//
//    @DirtiesContext
//    @Test
//    public void insertComment() {
//        final Comment comment = em.find(Comment.class, insertedComment.getId());
//        Assertions.assertTrue(comment.getComment_text().matches("Must read"));
//    }
//
//    @DirtiesContext
//    @Test
//    public void getCommentByBookId() {
//        em.refresh(insertedComment);
//        final List<Comment> commentByBookId = commentService.getCommentByBookId(testbook.getId());
//        Assertions.assertTrue(commentByBookId.get(0).getComment_text().matches("Must read"));
//    }
//
//    @DirtiesContext
//    @Test
//    public void deleteCommentByBookId() {
//        em.refresh(insertedComment);
//        commentsDaoJpa.deleteCommentByBookId(testbook.getId());
//        final List<Comment> all = commentService.getAllByBook(testbook.getId());
//        Assertions.assertEquals(0, all.size());
//    }
//}
