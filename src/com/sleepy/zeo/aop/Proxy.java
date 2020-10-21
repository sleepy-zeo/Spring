package com.sleepy.zeo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP(Aspect Oriented Programming)
 *
 * 设置切面
 */
@Aspect
@Component
public class Proxy {

    @Before("com.sleepy.zeo.aop.Pointcuts.pointcut()")
    public void before() {
        System.out.println("before ...");
    }

    @After("com.sleepy.zeo.aop.Pointcuts.pointcut()")
    public void after() {
        System.out.println("after ...");
    }

    @AfterReturning(pointcut = "com.sleepy.zeo.aop.Pointcuts.pointcut()", returning = "retVal")
    public void afterReturning(Object retVal) {
        if (retVal != null) {
            System.out.println("returning value->" + retVal.toString());
        }
    }

    @AfterThrowing(pointcut = "com.sleepy.zeo.aop.Pointcuts.pointcut()", throwing = "ex")
    public void afterThrowing(IllegalArgumentException ex) {
        System.out.println("error thows->" + ex.getMessage());
    }

    // 设置切入点
    // 这里设置的切入点为User的任意方法
    // 相当于是上面几个方法的汇总，但是注解的方式有别，并且可以共存，
    // 测试发现around要比上面几个方法先调用
    @Around("execution(* com.sleepy.zeo.model.User.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object returnValue = null;
        try {
            System.out.println("before invoke xxx");
            returnValue = joinPoint.proceed();
            System.out.println("after invoke xxx");
        } catch (Throwable e) {
            System.out.println("catch error while invoke xxx");
        }
        return returnValue;
    }
}
