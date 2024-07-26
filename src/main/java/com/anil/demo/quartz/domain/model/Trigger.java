package com.anil.demo.quartz.domain.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Trigger {
  private Long id;
  private JsonNode params;
  private String host;
  private String status;
  private String gameCode;
  private String drawNumber;
  private String drawYear;
  private Long triggerId;
}
