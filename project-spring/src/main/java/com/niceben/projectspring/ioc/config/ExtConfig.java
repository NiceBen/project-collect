package com.niceben.projectspring.ioc.config;

import com.niceben.projectspring.ioc.model.entity.Blue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan("com.niceben.projectspring.config.ext")
@Configuration
public class ExtConfig {

    @Bean
    public Blue blue() {
        return new Blue();
    }



}
