package com.example.driveit.model;

public class ModelHome {
    private String objectTitle, objectPrice, objectDuration;
    private int objectImage;

    public ModelHome(String objectTitle, String objectPrice, String objectDuration, int objectImage) {
        this.objectTitle = objectTitle;
        this.objectPrice = objectPrice;
        this.objectDuration = objectDuration;
        this.objectImage = objectImage;
    }

    public String getObjectTitle() {
        return objectTitle;
    }

    public void setObjectTitle(String objectTitle) {
        this.objectTitle = objectTitle;
    }

    public String getObjectPrice() {
        return objectPrice;
    }

    public void setObjectPrice(String objectPrice) {
        this.objectPrice = objectPrice;
    }

    public String getObjectDuration() {
        return objectDuration;
    }

    public void setObjectDuration(String objectDuration) {
        this.objectDuration = objectDuration;
    }

    public int getObjectImage() {
        return objectImage;
    }

    public void setObjectImage(int objectImage) {
        this.objectImage = objectImage;
    }
}
