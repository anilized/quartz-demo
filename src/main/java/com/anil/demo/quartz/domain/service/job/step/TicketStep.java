package com.anil.demo.quartz.domain.service.job.step;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.service.job.processor.factory.ProcessorFactory;
import com.anil.demo.quartz.domain.service.job.reader.factory.ReaderFactory;
import com.anil.demo.quartz.domain.service.job.step.factory.IStep;
import com.anil.demo.quartz.domain.service.job.writer.factory.WriterFactory;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;

public class TicketStep implements IStep<TicketEntity, Ticket> {

  @Autowired
  ReaderFactory readerFactory;

  @Autowired
  ProcessorFactory processorFactory;

  @Autowired
  WriterFactory writerFactory;

  @Autowired
  JobRepository jobRepository;

  @Autowired
  PlatformTransactionManager manager;
  @Override
  public Step getStep() {
    String stepName = "ticketPreSyncStep";
    StepBuilder stepBuilder = new StepBuilder(stepName, jobRepository);
    return stepBuilder
        .<TicketEntity, Ticket> chunk(100)
        .transactionManager(manager)
        .reader(readerFactory.getTicketReader().init())
        .processor(processorFactory.getTicketProcessor())
        .writer(writerFactory.getTicketWriter())
        .faultTolerant()
        .retryLimit(3)
        .retry(Exception.class)
        .build();
  }

}
