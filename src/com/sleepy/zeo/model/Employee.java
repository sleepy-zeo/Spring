package com.sleepy.zeo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 注解DI
@Component
public class Employee {

    private String name;
    private int age;
    @Autowired
    private Manager manager;

    @Override
    public String toString() {
        return "Employee[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", manager=" + manager +
                ']';
    }
}
