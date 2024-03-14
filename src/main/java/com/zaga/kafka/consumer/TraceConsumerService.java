package com.zaga.kafka.consumer;


import org.eclipse.microprofile.reactive.messaging.Incoming;

import com.zaga.entity.oteltrace.OtelTrace;
import com.zaga.handler.TraceCommandHandler;

import jakarta.inject.Inject;

public class TraceConsumerService {

    @Inject
    TraceCommandHandler traceCommandHandler;
    

    @Incoming("trace-in")
    public void consumeTraceDetails(OtelTrace trace) {
        System.out.println("consumed trace ------------------");
        traceCommandHandler.createTraceProduct(trace);
    }

}