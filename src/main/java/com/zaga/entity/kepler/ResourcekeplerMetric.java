package com.zaga.entity.kepler;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourcekeplerMetric {
    private KeplerResource resource;
    private List<ScopeMetric> scopeMetrics;
    private String schemaUrl;
}
