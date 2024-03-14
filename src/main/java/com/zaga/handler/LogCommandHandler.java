package com.zaga.handler;

import com.zaga.entity.auth.Rule;
import com.zaga.entity.auth.ServiceListNew;
import com.zaga.entity.otellog.OtelLog;
import com.zaga.entity.otellog.ResourceLogs;
import com.zaga.entity.otellog.ScopeLogs;
import com.zaga.entity.otellog.scopeLogs.LogRecord;
import com.zaga.entity.queryentity.log.LogDTO;
import com.zaga.kafka.alertProducer.AlertProducer;
import com.zaga.kafka.websocket.WebsocketAlertProducer;
import com.zaga.repo.LogCommandRepo;
import com.zaga.repo.LogQueryRepo;
import com.zaga.repo.ServiceListRepo;
import io.vertx.core.Vertx;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.EncodeException;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class LogCommandHandler {

  @Inject
  LogCommandRepo logCommandRepo;

  @Inject
  LogQueryRepo logQueryRepo;

  @Inject
  private WebsocketAlertProducer sessions;

  @Inject
  ServiceListRepo serviceListRepo;

  @Inject
  AlertProducer alertLogProducer;

  @Inject
  Vertx vertx;

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(
    "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
  );

  // private Map<String, Integer> alertCountMap = new HashMap<>();
  // private Map<String, String> previousTraceIdMap = new HashMap<>();

  public void createLogProduct(OtelLog logs) {
    logCommandRepo.persist(logs);
    List<LogDTO> logDTOs = marshalLogData(logs);
    System.out.println("log sizes" + logDTOs.size());

    ServiceListNew serviceListNew = new ServiceListNew();
    for (LogDTO logDTOSingle : logDTOs) {
        try {
            System.out.println("The log service rule getting from database");
            serviceListNew = serviceListRepo.find("serviceName = ?1", logDTOSingle.getServiceName())

                    .firstResult();
                                    System.out.println("The log service rule gotten from database");
            break;
        } catch (Exception e) {
            System.out.println("ERROR " + e.getLocalizedMessage());
        }
    }

    System.out.println("Log DTO size " + logDTOs.size());

    if (!serviceListNew.equals(null)) {
        System.out.println("The log rule is entered");
        for (LogDTO logDto : logDTOs) {
            System.out.println("Log DTO's " + logDto);
            processRuleManipulation(logDto, serviceListNew);
        }
    }

}




public void processRuleManipulation(LogDTO logDTO, ServiceListNew serviceListNew) {
    LocalDateTime currentDateTime = LocalDateTime.now();

    try {
        if (!serviceListNew.getRules().isEmpty()) {
            for (Rule sData : serviceListNew.getRules()) {
                if ("log".equals(sData.getRuleType())) {
                    LocalDateTime startDate = sData.getStartDateTime();
                    LocalDateTime expiryDate = sData.getExpiryDateTime();

                    if (startDate != null && expiryDate != null) {
                        String startDateTimeString = startDate.format(FORMATTER);
                        String expiryDateTimeString = expiryDate.format(FORMATTER);

                        LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, FORMATTER);
                        sData.setStartDateTime(startDateTime);

                        LocalDateTime expiryDateTime = LocalDateTime.parse(expiryDateTimeString, FORMATTER);
                        sData.setExpiryDateTime(expiryDateTime);

                        String severityText = logDTO.getSeverityText();
                        // String traceId = logDTO.getTraceId();
                        System.out.println("Log Severity " + severityText);

                        if (severityText != null && !severityText.isEmpty()) {
                          boolean isSeverityViolation = false;
                          List<String> severityPresent = sData.getSeverityText();
                          String severityConstraint = sData.getSeverityConstraint();
                      
                          switch (severityConstraint) {
                              case "present":
                                  isSeverityViolation = severityPresent.contains(severityText);
                                  break;
                              case "notpresent":
                                  isSeverityViolation = !severityPresent.contains(severityText);
                                  break;
                              default:
                                  break;
                          }
                      

                            if (isSeverityViolation && currentDateTime.isAfter(startDateTime) && currentDateTime.isBefore(expiryDateTime)) {
                                String serviceName = logDTO.getServiceName();

                                // List<String> severityTextList = sData.getSeverityText();
                                // String logSeverityText = logDTO.getSeverityText();

                                // if (severityTextList.contains(logSeverityText)) {
                                //     System.out.println("Log severity text matched");
                                    // Optionally send the alert here or perform other actions based on severity
                                    System.out.println(sData.getLogAlertSeverityText() + " - Log call exceeded for this service: " + serviceName + " at " + logDTO.getCreatedTime());
                                    sendAlert(new HashMap<>(), sData.getLogAlertSeverityText() + " - Log call exceeded for this service: " + serviceName + " at " + logDTO.getCreatedTime());
                                // } else {
                                //     System.out.println("No alert received");
                                // }
                            } else {
                                System.out.println("No Alert received for service ");
                            }
                        }
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
    alertPayload.put("alertType", "log");
    sessions
      .getSessions()
      .forEach(session -> {
        try {
          if (session == null) {
            System.out.println("No session");
          } else {
            session.getBasicRemote().sendObject(alertPayload);
            System.out.println(message);
          }
        } catch (IOException | EncodeException e) {
          e.printStackTrace();
        }
      });
    }
    
    public List<LogDTO> marshalLogData(OtelLog logs) {
    List<LogDTO> logDTOs = new ArrayList<>();
    LogDTO logDTO = new LogDTO();

    try {
      for (ResourceLogs resourceLog : logs.getResourceLogs()) {
        String serviceName = getServiceName(resourceLog);
        logDTO.setServiceName(serviceName);
        for (ScopeLogs scopeLog : resourceLog.getScopeLogs()) {
          for (LogRecord logRecord : scopeLog.getLogRecords()) {
            String traceId = logRecord.getTraceId();
            List<LogRecord> mockLog = new ArrayList<LogRecord>();

            // Create a new LogDTO for each LogRecord

            logDTO.setTraceId(traceId);
            logDTO.setSpanId(logRecord.getSpanId());
            logDTO.setSeverityText(logRecord.getSeverityText());
            logDTO.setCreatedTime(
              convertObservedTimeToIST(logRecord.getObservedTimeUnixNano())
            );

            mockLog.add(logRecord);

            ScopeLogs newScopeLogs = new ScopeLogs();
            newScopeLogs.setScope(scopeLog.getScope());
            newScopeLogs.setLogRecords(mockLog);

            logDTO.setScopeLogs(Collections.singletonList(newScopeLogs));

            // System.out.println("Log Data DTo " + logDTO);
            logDTOs.add(logDTO);
            logQueryRepo.persist(logDTO);
          }
        }
      }

      if (!logDTOs.isEmpty()) {
        // logQueryRepo.persist(logDTOs);
        return logDTOs;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return new ArrayList<>();
  }

  private String getServiceName(ResourceLogs resourceLog) {
    return resourceLog
      .getResource()
      .getAttributes()
      .stream()
      .filter(attribute -> "service.name".equals(attribute.getKey()))
      .findFirst()
      .map(attribute -> attribute.getValue().getStringValue())
      .orElse(null);
  }

  private static Date convertObservedTimeToIST(String observedTimeUnixNano) {
    long observedTimeMillis = Long.parseLong(observedTimeUnixNano) / 1_000_000;

    Instant instant = Instant.ofEpochMilli(observedTimeMillis);

    ZoneId istZone = ZoneId.of("Asia/Kolkata");
    LocalDateTime istDateTime = LocalDateTime.ofInstant(instant, istZone);

    return Date.from(istDateTime.atZone(istZone).toInstant());
  }
}
