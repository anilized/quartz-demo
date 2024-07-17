package com.anil.demo.quartz.application.api.rest.data;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CreateTicketsRequest {
    private List<TicketRequest> tickets;
}
