package com.anil.demo.quartz.infra.repository.adapters;

import com.anil.demo.quartz.domain.model.Trigger;
import com.anil.demo.quartz.domain.service.port.output.TriggerOutputPort;
import com.anil.demo.quartz.infra.repository.mapper.TriggerEntityMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TriggerMySQLAdapter implements TriggerOutputPort {

  private final TriggerRepository triggerRepository;
  private final TriggerEntityMapper triggerEntityMapper;

  @Override
  public List<Trigger> fetchTrigger() {
    return triggerEntityMapper.toDomainObjectList(triggerRepository
        .findByStatusAndHost("CREATED", "local1"));
  }

  @Override
  public void updateTriggerStatus(Long id, String status) {
    triggerRepository.updateStatusById(id, status);
  }
}
