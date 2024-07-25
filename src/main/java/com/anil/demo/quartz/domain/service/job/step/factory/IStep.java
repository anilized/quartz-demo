package com.anil.demo.quartz.domain.service.job.step.factory;

import org.springframework.batch.core.Step;

public interface IStep<I,O> {
  default Step getStep() {
    return getStep();
  }

}
