package com.zaga.kafka.consumer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.entity.oteltrace.OtelTrace;

public class TraceDeserialization implements Deserializer<OtelTrace>{
    private final ObjectMapper objectMapper;

    public TraceDeserialization() {
       this.objectMapper = new ObjectMapper();
    }
 
    @Override
    public OtelTrace deserialize(String topic, byte[] data) {
       try {
          return objectMapper.readValue(data, OtelTrace.class);
       } catch (Exception e) {
          throw new RuntimeException("Error deserializing JSON", e);
       }
    }
}


