package com.zaga.repo;

import com.zaga.entity.queryentity.log.LogDTO;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LogQueryRepo implements PanacheMongoRepository<LogDTO>{
    
}
