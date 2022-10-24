package com.niceben.projectspring.aop.mock;

import com.niceben.projectspring.aop.config.AspectConfig;
import com.niceben.projectspring.aop.service.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MockTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
        DemoService demo = context.getBean(DemoService.class);
        demo.everyDay();
    }
}
