package com.zaga.entity.queryentity.log;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zaga.entity.otellog.ScopeLogs;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("id")
@MongoEntity(collection = "LogDTO", database = "OtelLog")
public class LogDTO {
    private String serviceName;
    private String traceId;
    private String spanId;
    private Date createdTime;
    private String severityText;
    private List<ScopeLogs> scopeLogs;
}
