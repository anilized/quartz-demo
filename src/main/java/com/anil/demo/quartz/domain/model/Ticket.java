package com.anil.demo.quartz.domain.model;

import com.anil.demo.quartz.domain.model.enums.States;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    private Long id;
    private String prsn;
    private BigDecimal price;
    private States state;
}
