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
        .findByStatusAndHost("WAITING", "local1"));
  }

  @Override
  public void updateTriggerStatus(Long id, String status) {
    triggerRepository.updateStatusById(id, status);
  }

  @Override
  public void updateDependentTriggerStatus(String status, Long triggerId, String filterStatus) {
    triggerRepository.updateDependentTriggerStatus(status, triggerId, filterStatus);
  }

  @Override
  public void saveTrigger(Trigger trigger) {
    triggerRepository.save(triggerEntityMapper.toEntity(trigger));
  }
}
