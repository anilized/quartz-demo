package com.anil.demo.quartz.domain.service.job.writer;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.service.port.output.TicketOutputPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class TicketWriter implements ItemWriter<Ticket> {

  @Autowired
  TicketOutputPort ticketOutputPort;
  @Override
  public void write(Chunk<? extends Ticket> chunk) throws Exception {
    chunk.forEach(ticket -> ticketOutputPort.updateStatus(ticket));
  }
}
