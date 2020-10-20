package com.sleepy.zeo.model;

// xml DI
public class User {

    private String name;
    private int age;

    @Override
    public String toString() {
        return "User[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}
