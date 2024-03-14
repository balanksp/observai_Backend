package com.zaga.entity.pod.scopeMetric.sum;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sum {
    private List<SumDataPoint> dataPoints;
    @JsonProperty("aggregationTemporality")
    private int aggregationTemporality;
    @JsonIgnore
    @JsonProperty("isMonotonic")
    private boolean isMonotonic;
}
