package com.anil.demo.quartz.infra.repository.adapters;

import com.anil.demo.quartz.infra.repository.model.TriggerEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriggerRepository extends JpaRepository<TriggerEntity, Long> {
  List<TriggerEntity> findByStatusAndHost(String status, String host);

}
