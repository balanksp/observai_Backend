package com.zaga.entity.pod.scopeMetric.sum;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumDataPointAttributeValue {
    @JsonProperty("stringValue")
    private String stringValue;
}
