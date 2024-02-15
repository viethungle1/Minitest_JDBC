package com.example.minitest_3table.model;

public class Category {
    private int id;
    private String name;
    private String desciption;

    public Category() {
    }

    public Category(String name, String desciption) {
        this.name = name;
        this.desciption = desciption;
    }

    public Category(int id, String name, String desciption) {
        this.id = id;
        this.name = name;
        this.desciption = desciption;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesciption() {
        return desciption;
    }

}
