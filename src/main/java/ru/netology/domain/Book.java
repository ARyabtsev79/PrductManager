package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)


public class Book extends Product {
    private String name;

    public Book(int id, String name, int cost, String author) {
        super(id, cost, name, author);
        this.name = name;
    }
}
