package com.anil.demo.quartz.domain.service.job.reader;

import org.springframework.batch.item.ItemReader;

public interface IReader<T> {
  public ItemReader<T> init();

}
