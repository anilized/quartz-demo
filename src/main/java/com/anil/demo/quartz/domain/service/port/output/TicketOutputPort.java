package com.anil.demo.quartz.domain.service.port.output;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;

import java.util.List;

public interface TicketOutputPort {
    void createTickets(List<Ticket> tickets);
    void createTicket(Ticket ticket);
}
