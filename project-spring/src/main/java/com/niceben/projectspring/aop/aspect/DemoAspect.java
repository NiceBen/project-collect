package com.niceben.projectspring.aop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoAspect {

    @Pointcut("execution(* com.niceben.projectspring.aop.service.DemoService.everyDay())")
    private void myPointcut() {

    }

    // 前置通知
    @Before("myPointcut()")
    public void myBefore() {
        System.out.println("前置");
    }

    // 后置通知
    @AfterReturning("myPointcut()")
    public void myAfterReturning() {
        System.out.println("后置");
    }
}
