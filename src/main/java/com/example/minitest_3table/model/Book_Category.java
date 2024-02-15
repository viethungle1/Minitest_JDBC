package com.example.minitest_3table.model;

public class Book_Category {
    private int id_book;
    private int id_category;

    public Book_Category() {
    }

    public Book_Category(int id_book, int id_category) {
        this.id_book = id_book;
        this.id_category = id_category;
    }

    public int getId_book() {
        return id_book;
    }

    public void setId_book(int id_book) {
        this.id_book = id_book;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
