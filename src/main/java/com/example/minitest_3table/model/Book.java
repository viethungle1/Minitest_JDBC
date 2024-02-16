package com.example.minitest_3table.model;
import java.util.List;

public class Book {
    private int id;
    private String name;
    private String author;
    private String description;
    private List<Category> categories;

    public Book() {
    }

    public Book(String name, String author, String description) {
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Book(int id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public Book(int id, String name, String author, String description, List<Category> categories) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public List<Category> getCategories() {
        return categories;
    }
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
