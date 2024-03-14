package com.zaga.entity.queryentity.cluster_utilization;

import java.util.Date;

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
@MongoEntity(collection = "ClusterDTO", database = "OtelClusterUtilization")
public class ClusterUtilizationDTO extends PanacheMongoEntity{
     private Date date;
     private String nodeName;
     private String clusterName;
     private Double cpuUsage;
     private Long memoryCapacity;
     private Long memoryUsage;
     private Long memoryAvailable;
     private Long fileSystemCapacity;
     private Long fileSystemUsage;
     private Long fileSystemAvailable;
   }
