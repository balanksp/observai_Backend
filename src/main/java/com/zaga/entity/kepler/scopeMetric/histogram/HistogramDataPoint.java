package com.zaga.entity.kepler.scopeMetric.histogram;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistogramDataPoint {
    private List<HistogramDataPointAttribute> attributes;
    private String startTimeUnixNano;
    private String timeUnixNano;
    private String count;
    private double sum;
    private List<String> bucketCounts;
    private List<String> explicitBounds;
    private List<Exemplar> exemplars;
    private double min;
    private double max;
}
