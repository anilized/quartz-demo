package com.anil.demo.quartz.domain.service.job.listener;

import com.anil.demo.quartz.domain.service.port.output.TriggerOutputPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class TicketJobListener implements JobExecutionListener {

    private final TriggerOutputPort triggerOutputPort;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("JOB WITH ID: {} AND NAME: {} STARTED",
                jobExecution.getJobInstance().getInstanceId(),
                jobExecution.getJobInstance().getJobName());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        String exitStatus;
        if (!jobExecution.getExitStatus().getExitCode().equals(ExitStatus.COMPLETED.getExitCode())) {
            exitStatus = jobExecution.getExitStatus().getExitCode();

        } else {
            exitStatus = ExitStatus.COMPLETED.getExitCode();
            triggerOutputPort.updateDependentTriggerStatus("WAITING", jobExecution.getJobParameters().getLong("triggerId"), "CREATED");
        }

        log.info("JOB {} COMPLETED WITH EXIT STATUS OF {}", jobExecution.getJobInstance().getJobName(), jobExecution.getExitStatus().getExitDescription());

        triggerOutputPort.updateTriggerStatus(jobExecution.getJobParameters().getLong("id"),
                exitStatus);

        log.info("TRIGGER WITH ID {} STATUS UPDATED", jobExecution.getJobParameters().getLong("id"));

    }
}
