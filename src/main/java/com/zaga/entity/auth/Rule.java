package com.zaga.entity.auth;

import java.time.LocalDateTime;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rule {

    private String memoryConstraint;
    private LocalDateTime expiryDateTime;
    private long duration;
    private double cpuLimit;
    private Integer memoryLimit;
    private String ruleType;
    private LocalDateTime startDateTime;
    private String cpuConstraint;
    private String durationConstraint;
    private List<String> severityText;
    private String severityConstraint;
    private String cpuAlertSeverityText;
    private String memoryAlertSeverityText;
    private String tracecAlertSeverityText;
    private String logAlertSeverityText;
}
