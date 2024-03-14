package com.zaga.entity.otelmetric.scopeMetric.histogram;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exemplar {
    private List<FilteredAttribute> filteredAttributes;
    private String timeUnixNano;
    private double asDouble;
    private Integer asInt;
    private String spanId;
    private String traceId;
}
