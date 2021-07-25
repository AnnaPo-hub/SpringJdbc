package ru.otus.SpringJdbc.HomeworkSpringJdbc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CommentDto {
    private Long bookId;
    private String comment;
    private String author;
    private LocalDate date;
}
