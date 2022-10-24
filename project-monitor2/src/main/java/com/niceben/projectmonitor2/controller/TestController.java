package com.niceben.projectmonitor2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path = "/hello")
    public String hello() {

        return "hello :" + new Random().nextInt(10);
    }
}
