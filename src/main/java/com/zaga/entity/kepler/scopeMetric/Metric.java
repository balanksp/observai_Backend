package com.zaga.entity.kepler.scopeMetric;

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
    private MetricSummary summary;
    private MetricSum sum;
    private MetricGauge gauge;
    private MetricHistogram histogram;
    
    

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return String return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return MetricSummary return the summary
     */
    public MetricSummary getSummary() {
        return summary;
    }

    /**
     * @param summary the summary to set
     */
    public void setSummary(MetricSummary summary) {
        this.summary = summary;
    }

    /**
     * @return MetricSum return the sum
     */
    public MetricSum getSum() {
        return sum;
    }

    /**
     * @param sum the sum to set
     */
    public void setSum(MetricSum sum) {
        this.sum = sum;
    }

    /**
     * @return MetricGauge return the gauge
     */
    public MetricGauge getGauge() {
        return gauge;
    }

    /**
     * @param gauge the gauge to set
     */
    public void setGauge(MetricGauge gauge) {
        this.gauge = gauge;
    }

    /**
     * @return MetricHistogram return the histogram
     */
    public MetricHistogram getHistogram() {
        return histogram;
    }

    /**
     * @param histogram the histogram to set
     */
    public void setHistogram(MetricHistogram histogram) {
        this.histogram = histogram;
    }

    @Override
    public String toString() {
        return "Metric [name=" + name + ", description=" + description + ", unit=" + unit + ", summary=" + summary
                + ", sum=" + sum + ", gauge=" + gauge + ", histogram=" + histogram + "]";
    }

    
}
