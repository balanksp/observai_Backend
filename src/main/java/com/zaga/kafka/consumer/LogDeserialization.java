package com.zaga.kafka.consumer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.entity.otellog.OtelLog;

public class LogDeserialization implements Deserializer<OtelLog> {
     
   private final ObjectMapper objectMapper;

   public LogDeserialization(){
    this.objectMapper= new ObjectMapper();
   }


    @Override
    public OtelLog deserialize(String topic, byte[] data) {
      try {
         return objectMapper.readValue(data, OtelLog.class);
       } catch (Exception e) {
          throw new RuntimeException("Error deserializing JSON", e);
       }
      
    }
    
}
