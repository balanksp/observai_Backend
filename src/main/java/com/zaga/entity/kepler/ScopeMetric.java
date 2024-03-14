package com.zaga.entity.kepler;

import java.util.List;

import com.zaga.entity.kepler.scopeMetric.Metric;
import com.zaga.entity.kepler.scopeMetric.Scope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScopeMetric {
    private Scope scope;
    private List<Metric> metrics;
}
