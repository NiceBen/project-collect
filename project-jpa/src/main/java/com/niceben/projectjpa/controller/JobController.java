package com.niceben.projectjpa.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class JobController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @GetMapping("/doJob")
    public void doJob() {
        try {
            JobParametersBuilder builder = new JobParametersBuilder();
            builder.addDate("jobExcel", new Date());

            jobLauncher.run(job, builder.toJobParameters());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
