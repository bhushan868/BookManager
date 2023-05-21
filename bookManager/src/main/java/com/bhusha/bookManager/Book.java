package com.bhusha.bookManager;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Integer id;
    private String title;
    private String Author;
    private Integer pages;

    public Book() {

    }

    public Book(Integer id, String title, String author, Integer pages) {
        this.id = id;
        this.title = title;
        Author = author;
        this.pages = pages;
    }
}
