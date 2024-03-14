package com.zaga.entity.otelmetric.scopeMetric.sum;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumDataPoint {
    private List<SumDataPointAttribute> attributes;
    private String startTimeUnixNano;
    private String timeUnixNano;
    private String asInt;
    private String asDouble;
    private List<Exemplar> exemplars;

}
