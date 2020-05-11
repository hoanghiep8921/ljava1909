package com.example.demo.model;

public class Product {
    private String id;
    private String name;
    private String image;
    private String actor;
    private int year;

    public Product(String id, String name, String image, String actor, int year) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.actor = actor;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
