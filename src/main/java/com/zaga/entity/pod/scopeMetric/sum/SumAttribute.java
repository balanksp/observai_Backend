package com.zaga.entity.pod.scopeMetric.sum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumAttribute {
    private String key;
    private SumDataPointAttributeValue value;
}
