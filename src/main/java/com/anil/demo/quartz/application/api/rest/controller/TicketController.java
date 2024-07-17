package com.anil.demo.quartz.application.api.rest.controller;

import com.anil.demo.quartz.application.api.rest.data.CreateTicketsRequest;
import com.anil.demo.quartz.application.api.rest.data.TicketRequest;
import com.anil.demo.quartz.application.api.rest.mapper.RequestMapper;
import com.anil.demo.quartz.domain.service.impl.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;
    private final RequestMapper requestMapper;

    @PostMapping(path = "/subscription")
    public ResponseEntity<Void> createTickets(@RequestBody CreateTicketsRequest request) {
        ticketService.createTickets(requestMapper.toTicketList(request.getTickets()));
        return ResponseEntity.accepted().build();
    }

    @PostMapping(path = "/init")
    public ResponseEntity<Void> createTicket(@RequestBody TicketRequest request) {
        ticketService.createTicket(requestMapper.toDomain(request));
        return ResponseEntity.accepted().build();
    }

}
