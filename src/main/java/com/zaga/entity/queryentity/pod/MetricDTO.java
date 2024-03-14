package com.zaga.entity.queryentity.pod;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("id")
public class MetricDTO {
    private Date date;
    private Double cpuUsage;
    private Long memoryUsage;
    // private String serviceName;
    
}

