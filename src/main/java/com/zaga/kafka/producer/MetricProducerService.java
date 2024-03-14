// package com.zaga.kafka.producer;

// import org.eclipse.microprofile.reactive.messaging.Channel;
// import org.eclipse.microprofile.reactive.messaging.Emitter;


// import com.zaga.entity.otelmetric.OtelMetric;

// import jakarta.inject.Inject;

// public class MetricProducerService {
    
//     @Inject
//     // @Channel("metricData")
//     Emitter<OtelMetric>  producer;
//     public void sendMetric(OtelMetric otelMetric){
//         producer.send(otelMetric);
//     }
// }
