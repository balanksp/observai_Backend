package com.zaga.entity.clusterutilization.scopeMetric;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metric {
     
    @JsonIgnoreProperties("name")
    private String name;
    @JsonIgnoreProperties("description")
    private String description;
    @JsonIgnoreProperties("unit")
    private String unit;
    @JsonIgnoreProperties("sum")
    private MetricSum sum;
    @JsonIgnoreProperties("gauge")
    private MetricGauge gauge;
}
