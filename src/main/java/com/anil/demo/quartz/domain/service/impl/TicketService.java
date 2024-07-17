package com.anil.demo.quartz.domain.service.impl;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.model.enums.States;
import com.anil.demo.quartz.domain.service.port.input.CreateTicketsUseCase;
import com.anil.demo.quartz.domain.service.port.output.TicketOutputPort;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TicketService implements CreateTicketsUseCase {

    private final TicketOutputPort ticketOutputPort;

    @Override
    public void createTickets(List<Ticket> tickets) {
        tickets.forEach((t) -> {
            t.setState(States.CREATED);
        });
        ticketOutputPort.createTickets(tickets);
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketOutputPort.createTicket(ticket);
    }
}
