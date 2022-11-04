package com.niceben.projectmonitor2.controller;

import com.niceben.projectmonitor2.model.dto.User;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path = "/hello")
    public String hello() {

        return "hello :" + new Random().nextInt(10);
    }


    @PostMapping("/demo")
    public String demo(@RequestBody User user) {
        System.out.println(user);
        return "hello world";
    }
}
