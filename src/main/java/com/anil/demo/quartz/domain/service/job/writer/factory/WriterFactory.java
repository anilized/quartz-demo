package com.anil.demo.quartz.domain.service.job.writer.factory;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.service.job.writer.TicketWriter;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class WriterFactory {

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public ItemWriter<Ticket> getTicketWriter() {
    return new TicketWriter();
  }

}
