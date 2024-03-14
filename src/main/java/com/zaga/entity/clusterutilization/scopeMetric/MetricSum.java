package com.zaga.entity.clusterutilization.scopeMetric;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zaga.entity.clusterutilization.scopeMetric.sum.SumDataPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricSum {

    @JsonIgnoreProperties("dataPoints")
    private List<SumDataPoint> dataPoints;
    @JsonIgnoreProperties("aggregationTemporality")
    private int aggregationTemporality;
    @JsonIgnoreProperties("isMonotonic")
    private Boolean isMonotonic;

}
