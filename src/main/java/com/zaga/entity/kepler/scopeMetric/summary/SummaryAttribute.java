package com.zaga.entity.kepler.scopeMetric.summary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SummaryAttribute {
    private String key;
    private SummaryDataPointAttributeValue value;
}
