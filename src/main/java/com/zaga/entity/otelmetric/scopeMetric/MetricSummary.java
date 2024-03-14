package com.zaga.entity.otelmetric.scopeMetric;

import java.util.List;

import com.zaga.entity.otelmetric.scopeMetric.summary.SummaryDataPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricSummary {
    private List<SummaryDataPoint> dataPoints;
}
