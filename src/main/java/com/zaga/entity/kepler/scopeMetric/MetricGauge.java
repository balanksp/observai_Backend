package com.zaga.entity.kepler.scopeMetric;

import java.util.List;

import com.zaga.entity.kepler.scopeMetric.gauge.GaugeDataPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricGauge {
    private List<GaugeDataPoint> dataPoints;
    private int aggregationTemporality;



    /**
     * @return List<GaugeDataPoint> return the dataPoints
     */
    public List<GaugeDataPoint> getDataPoints() {
        return dataPoints;
    }

    /**
     * @param dataPoints the dataPoints to set
     */
    public void setDataPoints(List<GaugeDataPoint> dataPoints) {
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
        return "MetricGauge [dataPoints=" + dataPoints + ", aggregationTemporality=" + aggregationTemporality + "]";
    }

    

}
