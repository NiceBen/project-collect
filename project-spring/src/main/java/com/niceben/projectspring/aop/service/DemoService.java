package com.niceben.projectspring.aop.service;

import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DemoService {

    public void everyDay() {
        System.out.println("目标方法");
    }
}
