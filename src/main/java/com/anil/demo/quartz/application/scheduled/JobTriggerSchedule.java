package com.anil.demo.quartz.application.scheduled;

import com.anil.demo.quartz.domain.service.port.input.TriggerJobUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@EnableScheduling
@Component
public class JobTriggerSchedule {

  private final TriggerJobUseCase triggerJobUseCase;

  @Scheduled(fixedRate = 5000)
  public void triggerJobs() {
    log.info("===== FETCH TRIGGERS =====");
    triggerJobUseCase.triggerJobs();
  }

}
