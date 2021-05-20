package com.lullaby.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * AOP(Aspect Oriented Programming)
 *
 * 设置切面，这里设置的是User.*方法，在xml中隐式调用了setName并不会触发这里的切面
 */
@Aspect
@Component
public class Proxy {

    @Before("com.lullaby.aop.Pointcuts.pointcut()")
    public void before() {
        System.out.println("before ...");
    }

    @After("com.lullaby.aop.Pointcuts.pointcut()")
    public void after() {
        System.out.println("after ...");
    }

    @AfterReturning(pointcut = "com.lullaby.aop.Pointcuts.pointcut()", returning = "retVal")
    public void afterReturning(Object retVal) {
        if (retVal != null) {
            System.out.println("returning value->" + retVal.toString());
        }
    }

    @AfterThrowing(pointcut = "com.lullaby.aop.Pointcuts.pointcut()", throwing = "ex")
    public void afterThrowing(IllegalArgumentException ex) {
        System.out.println("error throws->" + ex.getMessage());
    }

    // 设置切入点，相当于是上面几个方法的汇总，可以和上面的方法共存
    // @Around("com.lullaby.aop.Pointcuts.pointcut()")
    @Around("execution(* com.lullaby.model.User.*(..))")
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
