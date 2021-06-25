package domain;

import lombok.Data;

import java.math.BigInteger;

@Data
public class Book {
    BigInteger id; // проверить тип
    Author author;
    String name;
    Genre genre;
}
