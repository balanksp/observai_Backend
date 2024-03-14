package com.zaga.entity.pod;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceMetric {
    private Resource resource;
    private List<ScopeMetrics> scopeMetrics;
    private String schemaUrl;
}
