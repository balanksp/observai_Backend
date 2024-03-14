package com.zaga.entity.otelmetric.scopeMetric.histogram;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Value {
    private String stringValue;
    private int intValue;
}
