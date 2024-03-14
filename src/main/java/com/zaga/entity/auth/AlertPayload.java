package com.zaga.entity.auth;

import java.util.Date;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@MongoEntity(collection="Alert",database = "ObservabilityCredentials")
public class AlertPayload extends PanacheMongoEntity{
    private String serviceName;
    private Date createdTime;
    private String traceId;
    private String alertMessage;
    private String type;

}
