package com.anil.demo.quartz.domain.service.port.input;

import com.anil.demo.quartz.domain.model.Ticket;

import java.util.List;

public interface CreateTicketsUseCase {
    void createTickets(List<Ticket> tickets);
    void createTicket(Ticket ticket);
}
