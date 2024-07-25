package com.anil.demo.quartz.domain.service.job.reader.factory;

import com.anil.demo.quartz.domain.service.job.reader.IReader;
import com.anil.demo.quartz.domain.service.job.reader.TicketReader;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ReaderFactory {

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public IReader<TicketEntity> getTicketReader() {
    return new TicketReader();
  }

}
