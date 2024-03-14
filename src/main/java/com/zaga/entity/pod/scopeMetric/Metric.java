package com.zaga.entity.pod.scopeMetric;

import com.zaga.entity.pod.scopeMetric.gauge.Gauge;
import com.zaga.entity.pod.scopeMetric.sum.Sum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metric {
    private String name;
    private String description;
    private String unit;
    private Sum sum;
    private Gauge gauge;
}
