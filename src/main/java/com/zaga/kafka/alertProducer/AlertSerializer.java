package com.zaga.kafka.alertProducer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaga.entity.auth.AlertPayload;

public class AlertSerializer implements Serializer<AlertPayload> {
        private final ObjectMapper objectMapper;

    public AlertSerializer() {
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public byte[] serialize(String topic, AlertPayload alertPayload) {
       try {
            System.out.println("--------------------------------"+ objectMapper.writeValueAsString(alertPayload));
            return objectMapper.writeValueAsBytes(alertPayload);

        } catch (Exception e) {
            throw new RuntimeException("Error serializing to JSON", e);
        }
    }
}
