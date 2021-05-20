package com.lullaby.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 注解DI
@Component
public class Employee {

    @Value("lullaby")
    private String name;
    @Value("34")
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
