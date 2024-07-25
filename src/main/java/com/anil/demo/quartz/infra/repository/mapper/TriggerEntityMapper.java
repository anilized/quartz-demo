package com.anil.demo.quartz.infra.repository.mapper;

import com.anil.demo.quartz.domain.model.Trigger;
import com.anil.demo.quartz.infra.repository.model.TriggerEntity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper
public interface TriggerEntityMapper {

  Trigger toDomain(TriggerEntity entity);

  default String jsonNodeToString(JsonNode jsonNode) {
    try {
      return jsonNode != null ? jsonNode.toString() : null;
    } catch (Exception e) {
      throw new RuntimeException("Failed to convert JsonNode to String", e);
    }
  }

  // Convert String to JsonNode
  default JsonNode stringToJsonNode(String jsonString) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      return jsonString != null ? objectMapper.readTree(jsonString) : null;
    } catch (Exception e) {
      throw new RuntimeException("Failed to convert String to JsonNode", e);
    }
  }

  default List<Trigger> toDomainObjectList(List<TriggerEntity> entities) {
    if (!entities.isEmpty()) {
      return entities.stream().map(this::toDomain).toList();
    }

    return null;
  }

}
