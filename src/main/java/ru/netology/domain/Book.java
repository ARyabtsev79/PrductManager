package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Book extends Product {
    private String author;


    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }
}
