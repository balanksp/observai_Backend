package com.zaga.entity.queryentity.kepler;

public class Resource {

    private String nameSpace;
    private String podName;
    private String containerId;
    private String containerName;
    private String metricsName;
    private String node;
    private String host;

    public Resource(String nameSpace, String podName, String containerId, String containerName, String metricsName, String node) {
        this.nameSpace = nameSpace;
        this.podName = podName;
        this.containerId = containerId;
        this.containerName = containerName;
        this.metricsName = metricsName;
        this.node = node;
    }

    public Resource() {
    }

    @Override
    public String toString() {
        return "Resource [nameSpace=" + nameSpace + ", podName=" + podName + ", containerId=" + containerId
                + ", containerName=" + containerName + ", metricsName=" + metricsName + ",node=" + node +"]";
    }

    /**
     * @return String return the nameSpace
     */
    public String getNameSpace() {
        return nameSpace;
    }

    /**
     * @param nameSpace the nameSpace to set
     */
    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    /**
     * @return String return the podName
     */
    public String getPodName() {
        return podName;
    }

    /**
     * @param podName the podName to set
     */
    public void setPodName(String podName) {
        this.podName = podName;
    }

    /**
     * @return String return the containerId
     */
    public String getContainerId() {
        return containerId;
    }

    /**
     * @param containerId the containerId to set
     */
    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    /**
     * @return String return the containerName
     */
    public String getContainerName() {
        return containerName;
    }

    /**
     * @param containerName the containerName to set
     */
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * @return String return the metricsName
     */
    public String getMetricsName() {
        return metricsName;
    }

    /**
     * @param metricsName the metricsName to set
     */
    public void setMetricsName(String metricsName) {
        this.metricsName = metricsName;
    }

    /**
     * @return String return the node
     */
    public String getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(String node) {
        this.node = node;
    }

    /**
     * @return String return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = host;
    }

}
