package com.example.driveit.model;

public class ModelHome {
    private int id;
    private String title, price, duration, image;

    public ModelHome(int id, String title, String price, String duration, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.duration = duration;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
