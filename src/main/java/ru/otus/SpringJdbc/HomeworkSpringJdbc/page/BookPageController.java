package ru.otus.SpringJdbc.HomeworkSpringJdbc.page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class BookPageController {
    @GetMapping("/")
    public String listPage() {
        return "books/index";
    }
}
