package com.zaga.repo;

import com.zaga.entity.auth.AlertPayload;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class AlertPayloadRepo implements PanacheMongoRepository<AlertPayload>{
    
}
