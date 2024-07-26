package com.anil.demo.quartz.infra.repository.adapters;

import com.anil.demo.quartz.infra.repository.model.TriggerEntity;
import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, Long> {

  List<TriggerEntity> findByStatusAndHost(String status, String host);

  @Modifying
  @Transactional
  @Query("update TriggerEntity t SET t.status = :status where t.id = :id")
  void updateStatusById(Long id, String status);

}
