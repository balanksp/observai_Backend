package com.zaga.entity.clusterutilization;

import java.util.List;

import com.zaga.entity.clusterutilization.scopeMetric.Metric;
import com.zaga.entity.clusterutilization.scopeMetric.Scope;

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
