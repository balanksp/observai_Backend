package com.zaga.entity.kepler.scopeMetric.histogram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exemplar {
    private String timeUnixNano;
    private double asDouble;
    private Integer asInt;
    private String spanId;
    private String traceId;
    
}
