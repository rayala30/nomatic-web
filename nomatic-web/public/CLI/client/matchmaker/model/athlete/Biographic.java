package com.rayala30.nomatic.client.matchmaker.model.athlete;

public class Biographic {
    // instance variables
    private String name;
    private int age;
    private String gender;


    // constructor
    public Biographic(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Biographic(String name) {
        this.name = name;
    }

    public Biographic() {

    }


    // getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
