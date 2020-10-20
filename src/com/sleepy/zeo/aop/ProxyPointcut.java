package com.sleepy.zeo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProxyPointcut {

//    @Before("com.sleepy.zeo.aop.AOPConfiguration.pointcut()")
//    public void beforeAdvice() {
//        System.out.println("before ...");
//    }
//
//    @After("com.sleepy.zeo.aop.AOPConfiguration.pointcut()")
//    public void afterAdvice() {
//        System.out.println("after ...");
//    }
//
//    @AfterReturning(pointcut = "com.sleepy.zeo.aop.AOPConfiguration.pointcut()", returning = "retVal")
//    public void afterReturningAdvice(Object retVal) {
//        if (retVal != null) {
//            System.out.println("returning value->" + retVal.toString());
//        }
//    }
//
//    @AfterThrowing(pointcut = "com.sleepy.zeo.aop.AOPConfiguration.pointcut()", throwing = "ex")
//    public void afterThrowingAdvice(IllegalArgumentException ex) {
//        System.out.println("error thows->" + ex.getMessage());
//    }
//
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
