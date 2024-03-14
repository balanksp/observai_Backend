// package com.zaga.kafka.producer;

// import org.apache.kafka.common.serialization.Serializer;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.zaga.entity.otellog.OtelLog;

// public class LogSerializer implements Serializer<OtelLog> {

//      private final ObjectMapper objectMapper;

//     public LogSerializer() {
//         this.objectMapper = new ObjectMapper();
//     }
//     @Override
//     public byte[] serialize(String topic, OtelLog otelLog) {
//        try {
//             return objectMapper.writeValueAsBytes(otelLog);
//         } catch (Exception e) {
//             throw new RuntimeException("Error serializing to JSON", e);
//         }
//     }
       


//     @Override
//     public void close() {
//         // No resources to close for this serializer
//     }
// }
