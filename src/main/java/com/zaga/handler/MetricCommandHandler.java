package com.zaga.handler;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zaga.entity.auth.AlertPayload;
import com.zaga.entity.auth.Rule;
import com.zaga.entity.auth.ServiceListNew;
import com.zaga.entity.otelmetric.OtelMetric;
import com.zaga.entity.otelmetric.ResourceMetric;
import com.zaga.entity.otelmetric.ScopeMetric;
import com.zaga.entity.otelmetric.scopeMetric.Metric;
import com.zaga.entity.otelmetric.scopeMetric.MetricGauge;
import com.zaga.entity.otelmetric.scopeMetric.MetricSum;
import com.zaga.entity.otelmetric.scopeMetric.gauge.GaugeDataPoint;
import com.zaga.entity.otelmetric.scopeMetric.sum.SumDataPoint;
import com.zaga.entity.queryentity.metrics.MetricDTO;
import com.zaga.kafka.alertProducer.AlertProducer;
import com.zaga.kafka.websocket.WebsocketAlertProducer;
import com.zaga.repo.MetricCommandRepo;
import com.zaga.repo.MetricDTORepo;
import com.zaga.repo.ServiceListRepo;

import io.vertx.core.Vertx;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.EncodeException;

@ApplicationScoped
public class MetricCommandHandler {

    @Inject
    MetricCommandRepo metricCommandRepo;

    @Inject
    MetricDTORepo metricDtoRepo;

    @Inject
    private WebsocketAlertProducer sessions;

    @Inject
    ServiceListRepo serviceListRepo;

    @Inject
    AlertProducer metricAlertProducer;

    @Inject
    Vertx vertx;

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public void createMetricProduct(OtelMetric metrics) {
        metricCommandRepo.persist(metrics);

        List<MetricDTO> metricDTOs = extractAndMapData(metrics);
        ServiceListNew serviceListData1 = new ServiceListNew();
        for (MetricDTO metricDTOSingle : metricDTOs) {
            System.out.println("The metric rule fetching from the data base");
            serviceListData1 = serviceListRepo.find("serviceName = ?1", metricDTOSingle.getServiceName()).firstResult();

            System.out.println("The metric rule fetched from the data base"+serviceListData1);
            break;
        }
        for (MetricDTO metricDTO : metricDTOs) {
            System.out.println("The Process rule entered");
            processRuleManipulation(metricDTO, serviceListData1);
        }
        System.out.println("---------MetricDTOs:---------- " + metricDTOs.size());
    }
    
    
    public void processRuleManipulation(MetricDTO metricDTO, ServiceListNew serviceListData) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        try {
            if (!serviceListData.getRules().isEmpty()) {
                for (Rule sData : serviceListData.getRules()) {
                    if ("metric".equals(sData.getRuleType())) {
                        LocalDateTime startDate = sData.getStartDateTime();
                        LocalDateTime expiryDate = sData.getExpiryDateTime();
                        if (startDate != null && expiryDate != null) {
                            String startDateTimeString = startDate.format(FORMATTER);
                            String expiryDateTimeString = expiryDate.format(FORMATTER);

                            LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, FORMATTER);
                            sData.setStartDateTime(startDateTime);

                            LocalDateTime expiryDateTime = LocalDateTime.parse(expiryDateTimeString, FORMATTER);
                            sData.setExpiryDateTime(expiryDateTime);
                            Double cpuLimit = sData.getCpuLimit();
                            Double cpuUsage = metricDTO.getCpuUsage();
                            Double cpuLimitMilliCores = cpuLimit * 1000;
                            Integer memoryUsage = metricDTO.getMemoryUsage();

                            Map<String, String> alertPayload = new HashMap<>();

                            if (cpuUsage != null && memoryUsage != null && cpuUsage != 0 && memoryUsage != 0) {
                                boolean isCpuViolation = false;
                                boolean isMemoryViolation = false;
                                // double cpuLimit = sData.getCpuLimit();
                                Integer memoryLimit = sData.getMemoryLimit();
                                String memoryConstraint = sData.getMemoryConstraint();
                                String cpuConstraint = sData.getCpuConstraint();
                            
                                switch (cpuConstraint) {
                                    case "greaterThan":
                                        isCpuViolation = cpuUsage > cpuLimitMilliCores;
                                        break;
                                    case "lessThan":
                                        isCpuViolation = cpuUsage < cpuLimitMilliCores;
                                        break;
                                    case "greaterThanOrEqual":
                                        isCpuViolation = cpuUsage >= cpuLimitMilliCores;
                                        break;
                                    case "lessThanOrEqual":
                                        isCpuViolation = cpuUsage <= cpuLimitMilliCores;
                                        break;
                                }
                            
                                switch (memoryConstraint) {
                                    case "greaterThan":
                                        isMemoryViolation = memoryUsage > memoryLimit;
                                        break;
                                    case "lessThan":
                                        isMemoryViolation = memoryUsage < memoryLimit;
                                        break;
                                    case "greaterThanOrEqual":
                                        isMemoryViolation = memoryUsage >= memoryLimit;
                                        break;
                                    case "lessThanOrEqual":
                                        isMemoryViolation = memoryUsage <= memoryLimit;
                                        break;
                                }
                                
                                AlertPayload alertPayload2 = new AlertPayload();

                                if (isCpuViolation && currentDateTime.isAfter(startDateTime) && currentDateTime.isBefore(expiryDateTime)) {
                                    // System.out.println("OUT");
                                    // String cpuSeverity = calculateSeverity(cpuUsage, cpuLimitMilliCores);
                                    System.out.println(sData.getCpuAlertSeverityText() + " - CPU Usage " + Math.ceil(cpuUsage) + " peaked in this service " + metricDTO.getServiceName());
                                    sendAlert(alertPayload,"" + sData.getCpuAlertSeverityText() + "- CPU Usage " + Math.ceil(cpuLimitMilliCores)
                                            + "  peaked in this service " + metricDTO.getServiceName());
                                    System.out.println("peaked in this service------------ " + alertPayload);
                                    String cpuAlertMessage = sData.getCpuAlertSeverityText() + "- CPU Usage " + Math.ceil(cpuUsage) + " peaked in this service " + metricDTO.getServiceName();

                                    alertPayload2.setServiceName(metricDTO.getServiceName());
                                    alertPayload2.setCreatedTime(metricDTO.getDate());
                                    alertPayload2.setType(sData.getRuleType());
                                    alertPayload2.setAlertMessage(cpuAlertMessage);
                                    metricAlertProducer.kafkaSend(alertPayload2);
                                }
                            
                                if (isMemoryViolation && currentDateTime.isAfter(startDateTime) && currentDateTime.isBefore(expiryDateTime)) {
                                    // System.out.println("OUT");
                                    // String memorySeverity = calculateSeverity(memoryUsage, memoryLimit);
                                sendAlert(alertPayload,"" + sData.getMemoryAlertSeverityText() + " - Memory Usage " + memoryUsage + " peaked in this service "
                                            + metricDTO.getServiceName() + "at" + metricDTO.getDate());
                                    System.out.println(sData.getMemoryAlertSeverityText() + " Alert - Memory Usage " + memoryUsage + " peaked in this service " + metricDTO.getServiceName());
                                }
                                
                            }
                            

                            // if (memoryUsage != null && memoryUsage != 0 && cpuUsage != null && cpuUsage != 0) {
                            //     if (memoryUsage >= sData.getMemoryLimit() &&
                            //             currentDateTime.isAfter(startDateTime) &&
                            //             currentDateTime.isBefore(expiryDateTime)) {
                            //         // Handle Memory Usage exceeded limit
                            //         sendAlert(alertPayload, "Memory Usage " + memoryUsage + " peaked in this service "
                            //                 + metricDTO.getServiceName());
                            //     }
                            // }

                            // if (cpuUsage != null && cpuUsage != 0 && memoryUsage != null && memoryUsage != 0) {
                            //     if (cpuUsage >= cpuLimitMilliCores &&
                            //             currentDateTime.isAfter(startDateTime) &&
                            //             currentDateTime.isBefore(expiryDateTime)) {
                            //         // Handle CPU Usage exceeded limit
                            //         sendAlert(alertPayload, "CPU Usage " + Math.ceil(cpuLimitMilliCores)
                            //                 + "  peaked in this service " + metricDTO.getServiceName());
                            //     }
                            // }
                        }
                        
                    }
                    
                }
                
            }
            
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }

  private void sendAlert(Map<String, String> alertPayload, String message) {
        alertPayload.put("alertMessage", message);
        alertPayload.put("alertType", "metric");
        sessions.getSessions().forEach(session -> {
            try {
                if (session == null) {
                    System.out.println("No session");
                } else {
                    System.out.println("Message sent to session " + session);
                    session.getBasicRemote().sendObject(alertPayload);
                    System.out.println("Message Metric sent");
                }
            } catch (IOException | EncodeException e) {
                e.printStackTrace();
            }
        });
    }

    public List<MetricDTO> extractAndMapData(OtelMetric metrics) {

        List<MetricDTO> metricDTOs = new ArrayList<>();

        Integer memoryUsage = 0;

        try {
            for (ResourceMetric resourceMetric : metrics.getResourceMetrics()) {
                String serviceName = getServiceName(resourceMetric);
                for (ScopeMetric scopeMetric : resourceMetric.getScopeMetrics()) {
                    Date createdTime = null;
                    Double cpuUsage = null;
                    String name = scopeMetric.getScope().getName();
                    if (name != null && name.contains("io.opentelemetry.runtime-telemetry")) {
                        List<Metric> metricsList = scopeMetric.getMetrics();
                        for (Metric metric : metricsList) {
                            String metricName = metric.getName();
                            if (isSupportedMetric(metricName)) {
                                if (metric.getSum() != null) {
                                    MetricSum metricSum = metric.getSum();
                                    List<SumDataPoint> sumDataPoints = metricSum.getDataPoints();

                                    for (SumDataPoint sumDataPoint : sumDataPoints) {
                                        String startTimeUnixNano = sumDataPoint.getTimeUnixNano();
                                        createdTime = convertUnixNanoToLocalDateTime(startTimeUnixNano);
                                        if (isMemoryMetric(metricName)) {
                                            if (sumDataPoint.getAsInt() != null && !sumDataPoint.getAsInt().isEmpty()) {
                                                String asInt = sumDataPoint.getAsInt();
                                                int currentMemoryUsage = Integer.parseInt(asInt);
                                                System.out.println("--------Memory usage:----- " + currentMemoryUsage);

                                                memoryUsage += currentMemoryUsage;
                                            }
                                        }
                                    }
                                }
                                if (metric.getGauge() != null) {
                                    MetricGauge metricGauge = metric.getGauge();
                                    List<GaugeDataPoint> gaugeDataPoints = metricGauge.getDataPoints();
                                    for (GaugeDataPoint gaugeDataPoint : gaugeDataPoints) {
                                        if (isCpuMetric(metricName)) {
                                            if (gaugeDataPoint.getAsDouble() != null) {
                                                String asDouble = gaugeDataPoint.getAsDouble();
                                                System.out.println("--------asDOUBLE------" + asDouble);
                                                cpuUsage = Double.parseDouble(asDouble);
                                                System.out.println("--------cpuUsage-------" + cpuUsage);
                                            }
                                        }
                                    }
                                }

                                Integer memoryUsageInMb = (memoryUsage / (1024 * 1024));

                                MetricDTO metricDTO = new MetricDTO();
                                metricDTO.setMemoryUsage(memoryUsageInMb);
                                metricDTO.setDate(createdTime);
                                metricDTO.setServiceName(serviceName);
                                metricDTO.setCpuUsage(cpuUsage);
                                metricDTOs.add(metricDTO);
                            }
                        }
                    }
                }
            }

            if (!metricDTOs.isEmpty()) {
                metricDtoRepo.persist(metricDTOs.subList(metricDTOs.size() - 1, metricDTOs.size()));

            }
        } catch (Exception e) {
        }

        return metricDTOs;
    }

    private boolean isSupportedMetric(String metricName) {
        return Set.of(
                "process.runtime.jvm.threads.count",
                "process.runtime.jvm.system.cpu.utilization",
                "process.runtime.jvm.system.cpu.load_1m",
                "process.runtime.jvm.memory.usage",
                "process.runtime.jvm.memory.limit",
                "jvm.cpu.recent_utilization",
                "jvm.memory.used",
                "jvm.memory.limit").contains(metricName);
    }

    private boolean isMemoryMetric(String metricName) {
        return Set.of("process.runtime.jvm.memory.usage","jvm.memory.used").contains(metricName);
    }

    private boolean isCpuMetric(String metricName) {
        return Set.of("process.runtime.jvm.cpu.utilization", "process.runtime.jvm.system.cpu.utilization","jvm.cpu.recent_utilization")
                .contains(metricName);
    }

    private String getServiceName(ResourceMetric resourceMetric) {
        return resourceMetric
                .getResource()
                .getAttributes()
                .stream()
                .filter(attribute -> "service.name".equals(attribute.getKey()))
                .findFirst()
                .map(attribute -> attribute.getValue().getStringValue())
                .orElse(null);
    }

    // private Date convertUnixNanoToLocalDateTime(String startTimeUnixNano) {
    // long nanoValue = Long.parseLong(startTimeUnixNano);

    // // Convert Unix Nano timestamp to Instant
    // Instant instant = Instant.ofEpochSecond(nanoValue / 1_000_000_000, nanoValue
    // % 1_000_000_000);

    // // Convert Instant to Date
    // Date date = Date.from(instant);

    // // Return the Date object
    // return date;
    // }
    private static Date convertUnixNanoToLocalDateTime(String startTimeUnixNano) {
        long observedTimeMillis = Long.parseLong(startTimeUnixNano) / 1_000_000;

        Instant instant = Instant.ofEpochMilli(observedTimeMillis);

        ZoneId istZone = ZoneId.of("Asia/Kolkata");
        LocalDateTime istDateTime = LocalDateTime.ofInstant(instant, istZone);

        return Date.from(istDateTime.atZone(istZone).toInstant());

}
}