package com.example.minitest_3table.model;

public class BookCategory {
    private int id;
    private int id_book;
    private int id_category;
    public BookCategory() {
    }
    public BookCategory(int id_book, int id_category) {
        this.id_book = id_book;
        this.id_category = id_category;
    }

    public BookCategory(int id, int id_book, int id_category) {
        this.id = id;
        this.id_book = id_book;
        this.id_category = id_category;
    }

    public int getId() {
        return id;
    }

    public int getId_book() {
        return id_book;
    }

    public int getId_category() {
        return id_category;
    }
}
