package com.zaga.kafka.alertConsumer;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.entity.auth.AlertPayload;

public class AlertDeserializer implements Deserializer<AlertPayload>{
   
    
    private final ObjectMapper objectMapper;

     public AlertDeserializer(){
    this.objectMapper= new ObjectMapper();
   }
    
   @Override
   public AlertPayload deserialize(String topic, byte[] data) {
    if (data == null) {
        return null; // or throw an appropriate exception
    }
    try {
        return objectMapper.readValue(data, AlertPayload.class);
    } catch (Exception e) {
        // Log the exception
        System.out.println("Error deserializing JSON"+e);
        throw new RuntimeException("Error deserializing JSON", e);
    }
}
    
}
