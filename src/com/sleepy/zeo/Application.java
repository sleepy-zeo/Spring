package com.sleepy.zeo;

import com.sleepy.zeo.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanFactory
 *      是Spring里低层次的接口，提供了实例化Bean和获取Bean的功能，是最基础的容器
 *
 * ApplicationContext
 *      继承自BeanFactory，提供了更多的功能，是更高级的容器
 */
public class Application {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-config.xml");

        User user = context.getBean("user", User.class);
        System.out.println("==>" + user.toString());
    }
}
