package com.anil.demo.quartz.infra.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
public class TriggerEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String params;
  private String host;
  private String status;
  private String gameCode;
  private String drawNumber;
  private String drawYear;
  private Long triggerId;

  @PrePersist
  @PreUpdate
  public void calculateTriggerId() {
    if (this.gameCode != null && this.drawNumber != null && this.drawYear != null) {
      String combinedString = gameCode + drawNumber + drawYear;
      this.triggerId = Long.parseLong(combinedString); // Ensures positive Long value
    }
  }

}
