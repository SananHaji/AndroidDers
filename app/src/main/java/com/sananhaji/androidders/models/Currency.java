package com.sananhaji.androidders.models;

public class Currency {
    private int imageId;
    private String name;
    private Integer value;

    public Currency(int imageId, String name, Integer value) {
        this.imageId = imageId;
        this.name = name;
        this.value = value;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
