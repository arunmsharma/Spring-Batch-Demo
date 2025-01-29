//package com.spring.batch.demo.runner;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.JobParametersBuilder;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class JobRunner implements CommandLineRunner {
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Autowired
//    private Job firstJob;
//
//    @Override
//    public void run(String... args) throws Exception {
//        JobExecution execution = jobLauncher.run(
//                firstJob,
//                new JobParametersBuilder()
//                        .addLong("time", System.currentTimeMillis())
//                        .toJobParameters()
//        );
//        System.out.println("Job Status: " + execution.getStatus());
//    }
//}
