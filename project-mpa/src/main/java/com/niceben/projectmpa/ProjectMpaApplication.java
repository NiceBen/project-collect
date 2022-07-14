package com.niceben.projectmpa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.niceben.projectmpa.business.*.mapper")
@SpringBootApplication
public class ProjectMpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMpaApplication.class, args);
    }

}
