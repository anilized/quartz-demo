package com.anil.demo.quartz.domain.service.port.output;

import com.anil.demo.quartz.domain.model.Trigger;
import java.util.List;

public interface TriggerOutputPort {
  List<Trigger> fetchTrigger();
  void updateTriggerStatus(Long id, String status);
  void updateDependentTriggerStatus(String status, Long triggerId, String filterStatus);
  void saveTrigger(Trigger trigger);
}
