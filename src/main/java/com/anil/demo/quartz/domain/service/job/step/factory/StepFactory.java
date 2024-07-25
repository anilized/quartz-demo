package com.anil.demo.quartz.domain.service.job.step.factory;

import com.anil.demo.quartz.domain.service.job.step.TicketStep;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class StepFactory {

  @Bean
  @Scope(BeanDefinition.SCOPE_PROTOTYPE)
  public IStep getTicketStep() {
    return new TicketStep();
  }

}
