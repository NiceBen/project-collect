package com.niceben.projectevent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.niceben.projectevent.business.*.mapper")
@SpringBootApplication
public class ProjectEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectEventApplication.class, args);
    }

}
