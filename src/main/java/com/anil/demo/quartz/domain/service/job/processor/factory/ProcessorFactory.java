package com.anil.demo.quartz.domain.service.job.processor.factory;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.model.Trigger;
import com.anil.demo.quartz.domain.service.job.processor.TicketProcessor;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import com.anil.demo.quartz.infra.repository.model.TriggerEntity;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProcessorFactory {
  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public ItemProcessor<TicketEntity, Ticket> getTicketProcessor() {
    return new TicketProcessor();
  }
}
