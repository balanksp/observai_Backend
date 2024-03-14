package com.zaga.entity.auth;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({ "id" })
@MongoEntity(collection = "ServiceListNew", database = "ObservabilityCredentials")
public class ServiceListNew extends PanacheMongoEntity{

    private String serviceName;
    private List<String> roles;

    private List<Rule> rules;
}
