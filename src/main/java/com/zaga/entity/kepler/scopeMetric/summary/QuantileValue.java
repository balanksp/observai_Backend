package com.zaga.entity.kepler.scopeMetric.summary;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuantileValue {
    private double value;
    private double quantile;
}
