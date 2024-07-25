package com.anil.demo.quartz.domain.service.job.processor;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.model.Trigger;
import com.anil.demo.quartz.domain.model.enums.States;
import com.anil.demo.quartz.infra.repository.mapper.TicketEntityMapper;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import com.anil.demo.quartz.infra.repository.model.TriggerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemProcessor;
@RequiredArgsConstructor
public class TicketProcessor implements
    ItemProcessor<TicketEntity, Ticket> {

  @Override
  public Ticket process(TicketEntity entity) throws Exception {
    return Ticket.builder().id(entity.getId()).prsn(entity.getPrsn()).price(entity.getPrice()).state(
        States.IN_PROGRESS).build();
  }
}
