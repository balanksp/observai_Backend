package com.zaga.entity.clusterutilization.scopeMetric.sum;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumDataPoint {
    private String startTimeUnixNano;
    private String timeUnixNano;
    @JsonIgnoreProperties("asInt")
    private String asInt;
    @JsonIgnoreProperties("asDouble")
    private String asDouble;
}
