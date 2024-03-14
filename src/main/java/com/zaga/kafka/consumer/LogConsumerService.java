package com.zaga.kafka.consumer;


import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.zaga.entity.otellog.OtelLog;
import com.zaga.handler.LogCommandHandler;

import jakarta.inject.Inject;

public class LogConsumerService {
    
      @Inject
      private LogCommandHandler logCommandHandler;
       
      @Incoming("logs-in")
      public void consumeLogDetails(OtelLog logs) {
        System.out.println("consumed log -----------");
       logCommandHandler.createLogProduct(logs);
     }
}
