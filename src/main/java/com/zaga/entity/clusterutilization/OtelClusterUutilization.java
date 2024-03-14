package com.zaga.entity.clusterutilization;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@MongoEntity(collection = "ClusterUtilization", database = "OtelClusterUtilization")
public class OtelClusterUutilization  extends PanacheMongoEntity{
     private List<ResourceMetric> resourceMetrics;
}
