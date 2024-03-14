package com.zaga.entity.otelmetric.scopeMetric;

import java.util.List;

import com.zaga.entity.otelmetric.scopeMetric.sum.SumDataPoint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MetricSum {
    private List<SumDataPoint> dataPoints;
    private int aggregationTemporality;
    private Boolean isMonotonic;

    

    /**
     * @return List<SumDataPoint> return the dataPoints
     */
    public List<SumDataPoint> getDataPoints() {
        return dataPoints;
    }

    /**
     * @param dataPoints the dataPoints to set
     */
    public void setDataPoints(List<SumDataPoint> dataPoints) {
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

    /**
     * @return Boolean return the isMonotonic
     */
    public Boolean isIsMonotonic() {
        return isMonotonic;
    }

    /**
     * @param isMonotonic the isMonotonic to set
     */
    public void setIsMonotonic(Boolean isMonotonic) {
        this.isMonotonic = isMonotonic;
    }

    @Override
    public String toString() {
        return "MetricSum [dataPoints=" + dataPoints + ", aggregationTemporality=" + aggregationTemporality
                + ", isMonotonic=" + isMonotonic + "]";
    }

}
