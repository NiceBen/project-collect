package com.niceben.projecttest.sync;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public class MainTest {

//    @Test
    @BeforeEach
    public void testRecord() {
        byte bt = 0x01;
        VisitStatService.record(bt, 1);
        VisitStatService.record(bt, 2);
        VisitStatService.record(bt, 3);
        VisitStatService.record(bt, 3);
    }

    @Test
    public void testStart() {
        VisitStatService.start();
    }

    @Test
    public void testDestroy() throws InterruptedException {

        Thread.sleep(3*60*1000);
    }

}
