package com.zaga.kafka.alertProducer;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import com.zaga.entity.auth.AlertPayload;

import jakarta.inject.Inject;


public class AlertProducer {

        @Inject
        @Channel("alert-out")
        Emitter<AlertPayload> producer;
             
        public void kafkaSend(AlertPayload alertPayload) {
            try {
                System.out.println("Sending alertPayload: " + alertPayload);
        
                if (producer != null && alertPayload != null) {
                    producer.send(alertPayload);
                    System.out.println("AlertPayload sent successfully.");
                } else {
                    System.err.println("Error: producer or alertPayload is null");
                }
        
            } catch (Exception e) {
                System.err.println("Error sending alertPayload: " + e.getMessage());
                e.printStackTrace();
            }
        }
             
}
