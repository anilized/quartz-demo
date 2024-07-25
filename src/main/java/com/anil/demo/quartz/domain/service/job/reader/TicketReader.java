package com.anil.demo.quartz.domain.service.job.reader;

import com.anil.demo.quartz.domain.model.Ticket;
import com.anil.demo.quartz.domain.service.port.output.TicketOutputPort;
import com.anil.demo.quartz.infra.repository.adapters.TicketRepository;
import com.anil.demo.quartz.infra.repository.model.TicketEntity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


public class TicketReader implements IReader<TicketEntity> {

  @Autowired
  TicketRepository ticketRepository;

  @Override
  public RepositoryItemReader<TicketEntity> init() {
    RepositoryItemReader<TicketEntity> repositoryItemReader = new RepositoryItemReader<>();
    repositoryItemReader.setRepository(ticketRepository);
    repositoryItemReader.setMethodName("findByState");
    repositoryItemReader.setArguments(Arrays.asList("CREATED"));
    repositoryItemReader.setPageSize(100);
    HashMap<String, Direction> sorts = new HashMap<>();
    sorts.put("state", Sort.Direction.ASC);
    repositoryItemReader.setSort(sorts);
    return repositoryItemReader;
  }
}
