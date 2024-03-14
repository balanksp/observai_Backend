package com.zaga.entity.clusterutilization.scopeMetric;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zaga.entity.clusterutilization.scopeMetric.gauge.GaugeDataPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricGauge {

      @JsonIgnoreProperties("dataPoints")
      private List<GaugeDataPoint> dataPoints;
}
