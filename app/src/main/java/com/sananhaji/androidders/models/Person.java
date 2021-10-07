package com.sananhaji.androidders.models;

public class Person {
    private String nme;
    private String surname;
    private int age;
    private String job;

    public Person(String nme, String surname, int age, String job) {
        this.nme = nme;
        this.surname = surname;
        this.age = age;
        this.job = job;
    }

    public String getNme() {
        return nme;
    }

    public void setNme(String nme) {
        this.nme = nme;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
