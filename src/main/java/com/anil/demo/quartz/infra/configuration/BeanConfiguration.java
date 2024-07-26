package com.anil.demo.quartz.infra.configuration;

import com.anil.demo.quartz.domain.service.impl.TicketService;
import com.anil.demo.quartz.domain.service.impl.TriggerService;
import com.anil.demo.quartz.domain.service.job.listener.TicketJobListener;
import com.anil.demo.quartz.domain.service.job.step.factory.StepFactory;
import com.anil.demo.quartz.domain.service.port.output.TicketOutputPort;
import com.anil.demo.quartz.domain.service.port.output.TriggerOutputPort;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

  @Bean
  public TicketService ticketService(TicketOutputPort ticketOutputPort) {
    return new TicketService(ticketOutputPort);
  }

  @Bean
  public TriggerService triggerService(TriggerOutputPort triggerOutputPort, StepFactory stepFactory, JobLauncher jobLauncher, JobRepository jobRepository, TicketJobListener listener) {
    return new TriggerService(triggerOutputPort, stepFactory, jobLauncher, jobRepository, listener);
  }

}
