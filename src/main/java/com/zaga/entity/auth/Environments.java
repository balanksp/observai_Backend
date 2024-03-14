package com.zaga.entity.auth;

import jakarta.ws.rs.DefaultValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environments {
    private String clusterUsername;
    private String clusterPassword;
    private String hostUrl;
    private String clusterType;
    private long clusterId;
    private String clusterName;
    private String openshiftClusterName;
    @DefaultValue("active")
    private String clusterStatus;
}
