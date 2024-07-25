package com.anil.demo.quartz.infra.repository.adapters;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.service.port.output.TicketOutputPort;
import com.anil.demo.quartz.infra.repository.mapper.TicketEntityMapper;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TicketMySQLAdapter implements TicketOutputPort {

    private final TicketRepository ticketRepository;
    private final TicketEntityMapper entityMapper;
    @Override
    public void createTickets(List<Ticket> tickets) {
        ticketRepository.saveAll(entityMapper.toEntities(tickets));
    }

    @Override
    public void createTicket(Ticket ticket) {
        ticketRepository.save(entityMapper.toEntity(ticket));
    }

    @Override
    public void updateStatus(Ticket ticket) {
        ticketRepository.updateById(ticket.getId(), ticket.getState().getDescription());
    }
}
