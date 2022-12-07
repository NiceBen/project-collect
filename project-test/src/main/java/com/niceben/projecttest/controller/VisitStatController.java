package com.niceben.projecttest.controller;

import com.niceben.projecttest.task.VisitStatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitStatController {

    @GetMapping("/task/record")
    public String recordTask() {
        byte bt = 0x01;
        VisitStatService.record(bt, 1);
        VisitStatService.record(bt, 2);
        VisitStatService.record(bt, 3);
        VisitStatService.record(bt, 3);
        return "task is record!";
    }

    @GetMapping("/task/start")
    public String startTask() {
        VisitStatService.start();
        return "task is started!";
    }

    @GetMapping("/task/destroy")
    public String destroyTask() {
        VisitStatService.destroy();
        return "task is destroy";
    }
}
