package com.zaga.entity.otelmetric.scopeMetric.summary;

import java.util.List;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDataPoint {
    private String startTimeUnixNano;
    private List<SummaryDataPointAttribute> attributes;
            private String timeUnixNano;
            private String count;
            private double sum;
            private List<QuantileValue> quantileValues;

}

