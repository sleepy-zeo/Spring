package com.lullaby.aop;

import org.aspectj.lang.annotation.Pointcut;

public class Pointcuts {

    // 设置切入点
    // 这里设置的切入点为User的任意方法
    @Pointcut("execution(* com.lullaby.model.User.*(..))")
    public void pointcut() {
    }
}

