package com.zaga.kafka.consumer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.entity.otelmetric.OtelMetric;

public class MetricDeserialization implements Deserializer<OtelMetric> {
  
         
   private final ObjectMapper objectMapper;

   public MetricDeserialization(){
    this.objectMapper= new ObjectMapper();
   }
    @Override
    public OtelMetric deserialize(String topic, byte[] data) {
         try {
         return objectMapper.readValue(data, OtelMetric.class);
       } catch (Exception e) {
          throw new RuntimeException("Error deserializing JSON", e);
       }
    }
    
}
