package com.anil.demo.quartz.infra.repository.adapters;

import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
  Page<TicketEntity> findByState(String state, Pageable pageable);
  @Modifying
  @Transactional
  @Query("UPDATE TicketEntity t SET t.state = :state where t.id = :id")
  void updateById(Long id, String state);
}
