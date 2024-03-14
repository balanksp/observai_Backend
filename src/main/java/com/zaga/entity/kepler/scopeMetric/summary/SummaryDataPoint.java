package com.zaga.entity.kepler.scopeMetric.summary;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDataPoint {
    @JsonProperty("startTimeUnixNano")
    private String startTimeUnixNano;
    
    @JsonProperty("attributes")
    private List<SummaryAttribute> attributes;
    
    @JsonProperty("timeUnixNano")
    private String timeUnixNano;
    
    @JsonProperty("count")
    private String count;
    
    @JsonProperty("sum")
    private double sum;
    
    @JsonProperty("quantileValues")
    private List<QuantileValue> quantileValues;
}
