package ru.otus.SpringJdbc.HomeworkSpringJdbc.domain;

public class BookBo {
    int id; // проверить тип
    String author;
    String name;
    String genre;

    public BookBo(int id, String author, String name, String genre) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
