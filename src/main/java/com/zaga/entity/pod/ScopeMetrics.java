package com.zaga.entity.pod;

import java.util.List;

import com.zaga.entity.pod.scopeMetric.Metric;
import com.zaga.entity.pod.scopeMetric.Scope;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScopeMetrics {
    private Scope scope;
    private List<Metric> metrics;
}
