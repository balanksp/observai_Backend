package com.zaga.kafka.alertConsumer;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.zaga.entity.auth.AlertPayload;
import com.zaga.repo.AlertPayloadRepo;

import jakarta.inject.Inject;


public class AlertConsumer {
     
@Inject
AlertPayloadRepo alertPayloadRepo;

     @Incoming("alert-in")
      public void consumeLogDetails(AlertPayload alertPayload) {
          // String alertPayloadString = "AlertPayload{"
          //   + "serviceName='" + alertPayload.getServiceName() + '\''
          //   + ", createdTime=" + alertPayload.getCreatedTime()
          //   + ", traceId='" + alertPayload.getTraceId() + '\''
          //   // Add other attributes as needed
          //   + '}';
        System.out.println("-----------------------------consumer------------------------"+alertPayload);
     //    alertPayloadRepo.persist(alertPayload);
          
          System.out.println("Received alertPayload: " + alertPayload);
          alertPayloadRepo.persist(alertPayload);
          System.out.println("AlertPayload processed successfully.");

     }
}
