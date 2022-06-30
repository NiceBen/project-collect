package com.niceben.projectjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class ProjectJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectJpaApplication.class, args);
    }

}
