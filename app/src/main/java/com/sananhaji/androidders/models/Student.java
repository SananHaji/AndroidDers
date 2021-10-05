package com.sananhaji.androidders.models;

import androidx.annotation.DrawableRes;

public class Student {
    private @DrawableRes int imageId;
    private String name;
    private String surname;

    public Student() {
    }

    public Student(@DrawableRes int imageId, String name, String surname) {
        this.imageId = imageId;
        this.name = name;
        this.surname = surname;
    }

    public @DrawableRes int getImageId() {
        return imageId;
    }

    public void setImageId(@DrawableRes int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
