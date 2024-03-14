package com.zaga.entity.otelmetric.scopeMetric;

import java.util.List;

import com.zaga.entity.otelmetric.scopeMetric.histogram.HistogramDataPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricHistogram {
    private List<HistogramDataPoint> dataPoints;
    private int aggregationTemporality;



    /**
     * @return List<HistogramDataPoint> return the dataPoints
     */
    public List<HistogramDataPoint> getDataPoints() {
        return dataPoints;
    }

    /**
     * @param dataPoints the dataPoints to set
     */
    public void setDataPoints(List<HistogramDataPoint> dataPoints) {
        this.dataPoints = dataPoints;
    }

    /**
     * @return int return the aggregationTemporality
     */
    public int getAggregationTemporality() {
        return aggregationTemporality;
    }

    /**
     * @param aggregationTemporality the aggregationTemporality to set
     */
    public void setAggregationTemporality(int aggregationTemporality) {
        this.aggregationTemporality = aggregationTemporality;
    }

    @Override
    public String toString() {
        return "MetricHistogram [dataPoints=" + dataPoints + ", aggregationTemporality=" + aggregationTemporality + "]";
    }

}
