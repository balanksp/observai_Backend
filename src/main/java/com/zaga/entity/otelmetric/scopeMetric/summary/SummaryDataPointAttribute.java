package com.zaga.entity.otelmetric.scopeMetric.summary;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDataPointAttribute {
      private String key;
    private SumDataPointAttributeValue value; 
}
