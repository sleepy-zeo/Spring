package org.piper.springapp.service;

import org.piper.springapp.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    public User getUser(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }

    public User setUser(String name) {
        User user = new User();
        user.setName(name);
        user.setAge(28);
        return user;
    }
}
