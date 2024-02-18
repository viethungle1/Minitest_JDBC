package com.example.minitest_3table.model;

import java.util.List;

public class Category {
    private int id;
    private String name;
    private String description;

    public Category() {
    }

    public Category(String name, String desciption) {
        this.name = name;
        this.description = desciption;
    }

    public Category(int id, String name, String desciption) {
        this.id = id;
        this.name = name;
        this.description = desciption;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


}
