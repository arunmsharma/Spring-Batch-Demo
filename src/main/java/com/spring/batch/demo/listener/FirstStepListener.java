package com.spring.batch.demo.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class FirstStepListener implements StepExecutionListener {

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("before first step: "+stepExecution.getStepName());
        System.out.println("before first step: "+stepExecution.getJobExecution().getExecutionContext());
        System.out.println("Before first step: "+stepExecution.getExecutionContext());

        stepExecution.getExecutionContext().put("run by step","arunstep");
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("After first step: "+stepExecution.getStepName());
        System.out.println("After first step: "+stepExecution.getJobExecution().getExecutionContext());
        System.out.println("After first step: "+stepExecution.getExecutionContext());
        return null;
    }
}
