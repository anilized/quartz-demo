package com.anil.demo.quartz.infra.repository.mapper;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.model.enums.States;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface TicketEntityMapper {
    @Mapping(target = "id", ignore = true)
    TicketEntity toEntity(Ticket ticket);

    default List<TicketEntity> toEntities(List<Ticket> tickets) {
        List<TicketEntity> ticketEntities = new ArrayList<>();
        tickets.forEach((ticket) -> {
            ticketEntities.add(toEntity(ticket));
        });
        return ticketEntities;
    }

    String map(States states);
}
