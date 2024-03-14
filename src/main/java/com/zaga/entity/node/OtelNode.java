// package com.zaga.entity.node;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import com.zaga.entity.clusterutilization.ResourceMetric;

// import io.quarkus.mongodb.panache.PanacheMongoEntity;
// import io.quarkus.mongodb.panache.common.MongoEntity;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @EqualsAndHashCode(callSuper = false)
// @JsonIgnoreProperties("id")
// @MongoEntity(collection = "Node", database = "OtelNode")
// public class OtelNode extends PanacheMongoEntity{
//     private List<ResourceMetric> resourceMetrics;
// }
