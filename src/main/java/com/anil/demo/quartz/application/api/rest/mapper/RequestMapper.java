package com.anil.demo.quartz.application.api.rest.mapper;

import com.anil.demo.quartz.application.api.rest.data.TicketRequest;
import com.anil.demo.quartz.domain.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface RequestMapper {
    @Mapping(target = "id", ignore = true)
    Ticket toDomain(TicketRequest request);

    default List<Ticket> toTicketList(List<TicketRequest> ticketRequests) {
        List<Ticket> tickets = new ArrayList<Ticket>();
        for (TicketRequest ticketRequest : ticketRequests) {
            tickets.add(toDomain(ticketRequest));
        }
        return tickets;
    }
}
