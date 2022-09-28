package com.niceben.projectmonitor.controller;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    MeterRegistry registry;

    @GetMapping("/test")
    public String test() {
        registry.counter("test",
                        "from", "127.0.0.1",
                        "method", "test")
                .increment();
        return "ok";
    }
}
