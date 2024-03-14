package com.zaga.entity.queryentity.trace;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TraceClusterData {
    private String containerId;
    private String hostArch;
    private String hostName;
    private String k8sContainerName;
    private String k8sDeploymentName;
    private String k8sNamespaceName;
    private String k8sNodeName;
    private String k8sPodName;
    private String k8sReplicasetName;
    private String osDescription;
    private String osType;
    private String processCommandArgs;
    private String processExecutablePath;
    private int processPid;
    private String processRuntimeDescription;
    private String processRuntimeName;
    private String processRuntimeVersion;
    private String serviceName;
    private String telemetryAutoVersion;
    private String telemetrySdkLanguage;
    private String telemetrySdkName;
    private String telemetrySdkVersion;
}
