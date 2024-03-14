package com.zaga.entity.queryentity.trace;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zaga.entity.oteltrace.scopeSpans.Spans;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties("id")
@MongoEntity(collection="TraceDTO",database="OtelTrace")
public class TraceDTO extends PanacheMongoEntity{
    private String traceId;
    private String serviceName;
    private String methodName;
    private String operationName;
    private Long duration;
    private Long statusCode;
    private String spanCount;
    private Date createdTime;
    private List<Spans> spans;
}






   







    

