package com.zaga.entity.queryentity.trace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TraceMetrics {
    private String serviceName;
    private Long apiCallCount;
    private Long peakLatency;
    private Long totalErrorCalls;
    private Long totalSuccessCalls;
}
