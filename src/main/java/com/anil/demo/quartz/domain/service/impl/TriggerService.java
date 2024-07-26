package com.anil.demo.quartz.domain.service.impl;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.model.Trigger;
import com.anil.demo.quartz.domain.service.job.listener.TicketJobListener;
import com.anil.demo.quartz.domain.service.job.step.factory.StepFactory;
import com.anil.demo.quartz.domain.service.port.input.TriggerJobUseCase;
import com.anil.demo.quartz.domain.service.port.output.TriggerOutputPort;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import jakarta.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TriggerService implements TriggerJobUseCase {

  private final TriggerOutputPort triggerOutputPort;
  private final StepFactory stepFactory;
  private final JobLauncher jobLauncher;
  private final JobRepository jobRepository;
  private final TicketJobListener ticketJobListener;

  /*@PostConstruct
  public void constructTigger() {
    Trigger trigger = new Trigger();

    trigger.setId(1L);
    trigger.setHost("local1");
    trigger.setStatus("CREATED");
    trigger.setGameCode("18");
    trigger.setDrawYear("2024");
    trigger.setDrawNumber("23");

    triggerOutputPort.saveTrigger(trigger);
  }*/

  @Override
  public void triggerJobs() {

    List<Trigger> triggers = triggerOutputPort.fetchTrigger();

    if (null == triggers) {
      log.info("==== TRIGGER NOT FOUND, SKIPPING ===");
      return;
    }

    triggers.forEach(t -> {

      Job job = new JobBuilder("ticketPreSyncJob", jobRepository)
          .incrementer(new RunIdIncrementer())
          .listener(ticketJobListener)
          .flow(stepFactory.getTicketStep().getStep())
          .end()
          .build();

      try {
        JobExecution execution = jobLauncher.run(job, new JobParametersBuilder()
                .addDate("launchDate", new Date())
                .addLong("id", t.getId())
                .addLong("triggerId", t.getTriggerId())
            .toJobParameters());
      } catch (JobExecutionAlreadyRunningException | JobParametersInvalidException |
               JobInstanceAlreadyCompleteException | JobRestartException e) {
        throw new RuntimeException("Error executing job", e);
      }
    });
  }
}
