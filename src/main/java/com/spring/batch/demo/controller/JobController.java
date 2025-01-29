package com.spring.batch.demo.controller;

import com.spring.batch.demo.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/job")
public class JobController {


    @Autowired
    JobService jobService;

    @GetMapping("/start/{jobName}")
    public String startJob(@PathVariable("jobName") String jobName){
        jobService.startJob(jobName);
        return "Job started..";
    }
}
