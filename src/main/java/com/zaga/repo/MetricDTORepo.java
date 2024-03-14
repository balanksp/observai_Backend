package com.zaga.repo;

import com.zaga.entity.queryentity.metrics.MetricDTO;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MetricDTORepo implements PanacheMongoRepository<MetricDTO>{
    
}
