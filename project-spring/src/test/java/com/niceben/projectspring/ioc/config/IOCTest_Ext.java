package com.niceben.projectspring.ioc.config;

import com.niceben.projectspring.ioc.config.ExtConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest_Ext {

    @Test
    public void test01() {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExtConfig.class)) {



        }

    }


}
