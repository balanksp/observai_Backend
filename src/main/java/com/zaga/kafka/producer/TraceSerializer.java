// package com.zaga.kafka.producer;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.zaga.entity.oteltrace.OtelTrace;

// import org.apache.kafka.common.serialization.Serializer;

// public class TraceSerializer  implements Serializer<OtelTrace> {

//     private final ObjectMapper objectMapper;

//     public TraceSerializer() { 
//         this.objectMapper = new ObjectMapper();
//     }

//     @Override
//     public byte[] serialize(String topic, OtelTrace trace) {
//         try {
//             return objectMapper.writeValueAsBytes(trace);
//         } catch (Exception e) {
//             throw new RuntimeException("Error serializing to JSON", e);
//         }
//     }

//     @Override
//     public void close() {

//     }
    
// }
 