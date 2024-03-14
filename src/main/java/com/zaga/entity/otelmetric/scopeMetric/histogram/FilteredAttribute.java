package com.zaga.entity.otelmetric.scopeMetric.histogram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilteredAttribute {
    private String key;
    private Value value;
}

