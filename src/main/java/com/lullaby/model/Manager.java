package com.lullaby.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 注解DI
 *
 * 通过修改@Component的value值修改Bean实例的id，默认id即为类名首字母的小写
 * 通过@Scope的value修改scope属性，默认为singleton，可选的值还有prototype
 *
 * @Value 注入int、float、String等数据类型
 * @Autowired 按类型自动装配
 * @Qualifier 需要和@Autowired搭配使用。当一个Bean有多个实例的时候，@Qualifier用于指定某一个实例的id
 *
 * 控制反转Ioc(Inversion of Control)
 * 控制：传统的应用程序中，我们主动通过new创建对象，而在Spring框架中，由Ioc容器来控制对象的创建
 * 反转：传统的应用程序中，我们直接手动获取对象，而在Spring框架中则是由Ioc容器主动提供创建好的对象
 */
@Component(value = "manager")
@Scope(value = "prototype")
public class Manager {

    @Value("sleepy")
    private String name;
    @Value("32")
    public int age;

    @Override
    public String toString() {
        return "Manager[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ']';
    }
}
