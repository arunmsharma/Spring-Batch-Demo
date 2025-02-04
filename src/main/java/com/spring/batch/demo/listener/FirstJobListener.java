package com.spring.batch.demo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstJobListener implements JobExecutionListener {

    @Override
    public void beforeJob(JobExecution jobExecution){
        System.out.println("Before job: job name" + jobExecution.getJobInstance().getJobName());
        System.out.println("Before job: job params" + jobExecution.getJobParameters());
        System.out.println("Before job: job execution context" + jobExecution.getExecutionContext());

        jobExecution.getExecutionContext().put("Run by:","arun");
    }

    @Override
    public void afterJob(JobExecution jobExecution){
        System.out.println("After job: job name" + jobExecution.getJobInstance().getJobName());
        System.out.println("After job: job params" + jobExecution.getJobParameters());
        System.out.println("After job: job execution context" + jobExecution.getExecutionContext());
    }
}
