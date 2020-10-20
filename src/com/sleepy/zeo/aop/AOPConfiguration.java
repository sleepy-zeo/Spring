package com.sleepy.zeo.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AOPConfiguration {

    // 设置切入点
    // 这里设置的切入点为User的任意方法
    @Pointcut("execution(* com.sleepy.zeo.model.User.*(..))")
    public void pointcut() {
    }
}

