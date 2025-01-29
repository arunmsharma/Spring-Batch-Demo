package com.spring.batch.demo.service;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class JobService {

    @Autowired
    JobLauncher jobLauncher;

    @Qualifier("firstJob")
    @Autowired
    Job firstJob;


    @Qualifier("secondJob")
    @Autowired
    Job secondJob;


    public void startJob(String jobName){
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("CurrentTime", System.currentTimeMillis())
                .addString("Message", "Hey how are your ?")
                .toJobParameters();
        JobExecution jobExecution = null;
        try{
            if (jobName.equals("firstJob")) {
                jobExecution = jobLauncher.run(firstJob, jobParameters);
            } else if (jobName.equals("secondJob")) {
                jobExecution = jobLauncher.run(secondJob, jobParameters);
            }
            assert jobExecution != null;
            System.out.println("Job execution id:"+jobExecution.getJobId());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
