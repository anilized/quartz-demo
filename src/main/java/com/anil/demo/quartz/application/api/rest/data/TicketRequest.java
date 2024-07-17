package com.anil.demo.quartz.application.api.rest.data;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class TicketRequest {
    private String prsn;
    private BigDecimal price;
}
