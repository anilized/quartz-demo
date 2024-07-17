package com.anil.demo.quartz.infra.repository.adapters;

import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
