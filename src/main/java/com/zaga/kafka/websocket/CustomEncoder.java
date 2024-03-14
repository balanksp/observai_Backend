package com.zaga.kafka.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;

public class CustomEncoder implements Encoder.Text<Object> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String encode(Object data) throws EncodeException {
        try {
            String encodedString = objectMapper.writeValueAsString(data);
            return encodedString;
        } catch (JsonProcessingException e) {
            throw new EncodeException(data, "Failed to serialize object to JSON", e);
        }
    }

}
