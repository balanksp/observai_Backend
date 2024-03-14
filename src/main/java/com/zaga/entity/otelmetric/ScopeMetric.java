package com.zaga.entity.otelmetric;

import java.util.List;

import com.zaga.entity.otelmetric.scopeMetric.Metric;
import com.zaga.entity.otelmetric.scopeMetric.Scope;

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
