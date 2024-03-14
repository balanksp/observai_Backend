package com.zaga.entity.queryentity.kepler;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.quarkus.mongodb.panache.common.MongoEntity;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;

// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@JsonIgnoreProperties("id")
@MongoEntity(collection = "KeplerMetricDTO", database = "KeplerMetric")

public class KeplerMetricDTO {
    private Date date;
    private Double powerConsumption;
    private String serviceName;
    private String type;
    private String keplerType;
    private Resource resource;

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Double getPowerConsumption() {
        return powerConsumption;
    }
    public void setPowerConsumption(Double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }
    public String getKeplerType() {
        return keplerType;
    }
    public void setKeplerType(String keplerType) {
        this.keplerType = keplerType;
    }
    public String getServiceName() {
        return serviceName;
    }
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Resource getResource() {
        return resource;
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }
    @Override
    public String toString() {
        return "KeplerMetricDTO [date=" + date + ", powerConsumption=" + powerConsumption + ", serviceName="
                + serviceName + ", type=" + type +", KeplerType=" + keplerType + ", resource=" + resource + "]";
    }
    public KeplerMetricDTO(Date date, Double powerConsumption, String serviceName, String type, String keplerType,Resource resource) {
        this.date = date;
        this.powerConsumption = powerConsumption;
        this.serviceName = serviceName;
        this.type = type;
        this.keplerType=keplerType;
        this.resource = resource;
    }

        public KeplerMetricDTO() {
    }
}
