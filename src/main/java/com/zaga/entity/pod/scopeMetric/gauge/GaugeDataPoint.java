package com.zaga.entity.pod.scopeMetric.gauge;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GaugeDataPoint {
    
    @JsonProperty("startTimeUnixNano")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String startTimeUnixNano;
    @JsonProperty("timeUnixNano")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String timeUnixNano;
    @JsonProperty("asInt")
    private String asInt; 
    @JsonProperty("asDouble")
    private Double asDouble; 
}
