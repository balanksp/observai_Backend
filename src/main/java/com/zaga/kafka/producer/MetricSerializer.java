// package com.zaga.kafka.producer;

// import org.apache.kafka.common.serialization.Serializer;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.zaga.entity.otelmetric.OtelMetric;

// public class MetricSerializer implements Serializer<OtelMetric> {
//     private final ObjectMapper objectMapper;

//     public MetricSerializer(){
//         this.objectMapper=new ObjectMapper();
//     }
//     @Override
//     public byte[] serialize(String topic, OtelMetric otelMetric) {
//        try {
//         return objectMapper.writeValueAsBytes(otelMetric);

//        } catch (Exception e) {
//         throw new RuntimeException("Error serializing to JSON", e);
//        } 
//     }
    
// }
