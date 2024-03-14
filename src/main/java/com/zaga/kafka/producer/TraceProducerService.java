// package com.zaga.kafka.producer;

// import org.eclipse.microprofile.reactive.messaging.Channel;
// import org.eclipse.microprofile.reactive.messaging.Emitter;

// import com.zaga.entity.oteltrace.OtelTrace;

// import jakarta.inject.Inject;

// public class TraceProducerService {
//         @Inject
//         // @Channel("product") 
//         Emitter<OtelTrace> kafkaProducer;
    
//         public void sendProductDetails(OtelTrace trace) {
//             System.out.println(trace);
//             kafkaProducer.send(trace);
//         }
// }
