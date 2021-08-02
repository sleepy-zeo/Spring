package org.piper.springapp.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceInterceptor {

    @Pointcut("execution(* org.piper.springapp.service.UserService.*(..))")
    public void pointcut() {
    }

    @Before("pointcut() && args(name, ..)")
    public void before(String name) {
        System.out.println("before, name: " + name);
    }

    @After("pointcut()")
    public void after() {
        System.out.println("after");
    }

    @AfterReturning(value = "pointcut()", returning = "value")
    public void afterReturning(Object value) {
        System.out.println("after value: " + value);
    }

    @AfterThrowing(value = "pointcut()", throwing = "e")
    public void afterThrowing(Throwable e) {
        System.out.println("after error: " + e.getMessage());
    }
}
