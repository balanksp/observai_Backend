// package com.zaga.kafka.producer;

// import org.eclipse.microprofile.reactive.messaging.Channel;
// import org.eclipse.microprofile.reactive.messaging.Emitter;

// import com.zaga.entity.otellog.OtelLog;

// import jakarta.inject.Inject;

// public class LogProducerService {
    


//     @Inject
//     @Channel("logData")
//     Emitter<OtelLog>  producer;
//     public void sendLog(OtelLog otelLog){
//         producer.send(otelLog);
//     }

// }
