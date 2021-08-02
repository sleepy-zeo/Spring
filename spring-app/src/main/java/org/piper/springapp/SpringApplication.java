package org.piper.springapp;

import org.piper.springapp.domain.Manager;
import org.piper.springapp.domain.User;
import org.piper.springapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

    /**
     * BeanFactory
     *      是Spring里低层次的接口，提供了实例化Bean和获取Bean的功能，是最基础的容器
     *
     * ApplicationContext
     *      继承自BeanFactory，提供了更多的功能，是更高级的容器
     */
    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");

        User user = context.getBean("user", User.class);
        System.out.println("==>" + user);

        Manager manager = context.getBean("manager", Manager.class);
        System.out.println("==>" + manager);

        // 普通调用不会触发aop
        // UserService userService = new UserService();
        UserService userService = context.getBean("userService", UserService.class);
        userService.getUser("sleepy", 20);
        System.out.println("------");
        userService.setUser("sunbeam");
    }
}
