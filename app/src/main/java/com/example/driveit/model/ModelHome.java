package com.example.driveit.model;

public class ModelHome {
    private int id, price;
    private String title, duration, image;

    public ModelHome() {
    }

    public ModelHome(int id, int price, String title, String duration, String image) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.duration = duration;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}