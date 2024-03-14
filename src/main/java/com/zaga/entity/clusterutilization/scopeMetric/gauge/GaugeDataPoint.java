package com.zaga.entity.clusterutilization.scopeMetric.gauge;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GaugeDataPoint {

    @JsonIgnoreProperties("startTimeUnixNano")
    private String startTimeUnixNano;
    @JsonIgnoreProperties("timeUnixNano")
    private String timeUnixNano;
    @JsonIgnoreProperties("asInt")
    private String asInt;
    @JsonIgnoreProperties("asDouble")
    private String asDouble;
}
