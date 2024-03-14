package com.zaga.handler;

import com.zaga.entity.auth.AlertPayload;
import com.zaga.entity.auth.Rule;
import com.zaga.entity.auth.ServiceListNew;
import com.zaga.entity.oteltrace.OtelTrace;
import com.zaga.entity.oteltrace.ResourceSpans;
import com.zaga.entity.oteltrace.ScopeSpans;
import com.zaga.entity.oteltrace.scopeSpans.Spans;
import com.zaga.entity.oteltrace.scopeSpans.spans.Attributes;
import com.zaga.entity.queryentity.trace.TraceDTO;
import com.zaga.kafka.alertProducer.AlertProducer;
import com.zaga.kafka.websocket.WebsocketAlertProducer;
import com.zaga.repo.ServiceListRepo;
import com.zaga.repo.TraceCommandRepo;
import com.zaga.repo.TraceQueryRepo;

import io.vertx.core.Vertx;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.EncodeException;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TraceCommandHandler {

  @Inject
  TraceCommandRepo traceCommandRepo;

  @Inject
  TraceQueryRepo traceQueryRepo;

  @Inject
  private WebsocketAlertProducer sessions;

  @Inject
  ServiceListRepo serviceListRepo;

  @Inject
  AlertProducer alertProducer;

  @Inject
  Vertx vertx;

  private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

//   private Map<String, Integer> alertCountMap = new HashMap<>();

  public void createTraceProduct(OtelTrace trace) {
    traceCommandRepo.persist(trace);
   List<TraceDTO> traceDTOs = extractAndMapData(trace);
   ServiceListNew serviceListNew = new ServiceListNew();
   for (TraceDTO traceDTOSingle : traceDTOs) {
     try {
       serviceListNew = serviceListRepo.find("serviceName = ?1", traceDTOSingle.getServiceName()).firstResult();
       break;
     } catch (Exception e) {
       System.out.println("ERROR " + e.getLocalizedMessage());
     }
   }

   System.out.println("Trace DTO size " + traceDTOs.size());

   if (!serviceListNew.equals(null)) {
     for (TraceDTO traceDTO : traceDTOs) {
       // System.out.println("Trace DTO's " + traceDTO.toString());
       processRuleManipulation(traceDTO, serviceListNew);
     }
   }
 }

public void processRuleManipulation(TraceDTO traceDTO, ServiceListNew serviceListNew) {
  LocalDateTime currentDateTime = LocalDateTime.now();

      try {
          if (!serviceListNew.getRules().isEmpty()) {
              for (Rule sData : serviceListNew.getRules()) {
                  if ("trace".equals(sData.getRuleType())) {
                      processTraceRule(traceDTO, sData, currentDateTime);
                  }
              }
          }
      } catch (Exception e) {
      }
  
}

private void processTraceRule(TraceDTO traceDTO, Rule sData, LocalDateTime currentDateTime) {
  LocalDateTime startDate = sData.getStartDateTime();
  LocalDateTime expiryDate = sData.getExpiryDateTime();
  if (startDate != null && expiryDate != null) {
      String startDateTimeString = startDate.format(FORMATTER);
      String expiryDateTimeString = expiryDate.format(FORMATTER);

      LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, FORMATTER);
      sData.setStartDateTime(startDateTime);

      LocalDateTime expiryDateTime = LocalDateTime.parse(expiryDateTimeString, FORMATTER);
      sData.setExpiryDateTime(expiryDateTime);

      Long duration = traceDTO.getDuration();
      System.out.println("Trace duration------------------" + traceDTO.getDuration());
      if (duration != null && duration != 0) {
          boolean isDurationViolation = false;
          long durationLimit = sData.getDuration();
          String durationConstraint = sData.getDurationConstraint();

          switch (durationConstraint) {
              case "greaterThan":
                  isDurationViolation = duration > durationLimit;
                  break;
              case "lessThan":
                  isDurationViolation = duration < durationLimit;
                  break;
              case "greaterThanOrEqual":
                  isDurationViolation = duration >= durationLimit;
                  break;
              case "lessThanOrEqual":
                  isDurationViolation = duration <= durationLimit;
                  break;
          }

          if (isDurationViolation && currentDateTime.isAfter(startDateTime) && currentDateTime.isBefore(expiryDateTime)) {
              String serviceName = traceDTO.getServiceName();
            //   int alertCount = alertCountMap.getOrDefault(serviceName, 0);
            //   alertCount++;

            //   double percentageExceeded = ((double) (duration - durationLimit) / durationLimit) * 100;

            //   if (alertCount > 3) {
            //       System.out.println("Exceeded");
            //       String severity;
            //       if (percentageExceeded > 50) {
            //           severity = "Critical Alert";
            //       } else if (percentageExceeded >= 5 && percentageExceeded <= 15) {
            //           severity = "Medium Alert";
            //       } else {
            //           severity = "Low Alert";
            //       }
                  System.out.println(sData.getTracecAlertSeverityText() + " - Duration " + traceDTO.getDuration() + " exceeded for this service: " + serviceName +"at" + traceDTO.getCreatedTime());

                  sendAlert(new HashMap<>(), sData.getTracecAlertSeverityText() + " - Duration " + traceDTO.getDuration() + " exceeded for this service: " + serviceName + " at" + traceDTO.getCreatedTime());
                  String traceAlertMessage = sData.getTracecAlertSeverityText() + " - Duration " + traceDTO.getDuration() + " exceeded for this service: " + serviceName + " at" + traceDTO.getCreatedTime();

                  AlertPayload alertTracePayload = new AlertPayload();

                  alertTracePayload.setServiceName(serviceName);
                  alertTracePayload.setAlertMessage(traceAlertMessage);
                  alertTracePayload.setTraceId(traceDTO.getTraceId());
                  alertTracePayload.setCreatedTime(traceDTO.getCreatedTime());
                  alertTracePayload.setType(sData.getRuleType());

                  alertProducer.kafkaSend(alertTracePayload);

                //   System.out.println("sl");
              } else {
                  System.out.println("No Alert Received");
                //   alertCountMap.put(serviceName, alertCount);
              }
          }
      }
  }

private void sendAlert(Map<String, String> alertPayload, String message) {
  alertPayload.put("alertMessage", message);
  alertPayload.put("alertType", "trace");
  sessions.getSessions().forEach(session -> {
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

  // logic for getting serviceName
  private String getServiceName(ResourceSpans resourceSpans) {
    return resourceSpans
        .getResource()
        .getAttributes()
        .stream()
        .filter(attribute -> "service.name".equals(attribute.getKey()))
        .findFirst()
        .map(attribute -> attribute.getValue().getStringValue())
        .orElse(null);
  }

  // logic for calculating the createdtime
  private Date calculateCreatedTime(Spans span) {
    String startTimeUnixNano = span.getStartTimeUnixNano();
    long startUnixNanoTime = Long.parseLong(startTimeUnixNano);
    Instant startInstant = Instant.ofEpochSecond(
        startUnixNanoTime / 1_000_000_000L,
        startUnixNanoTime % 1_000_000_000L);
    ZoneId istZone = ZoneId.of("Asia/Kolkata");

    ZonedDateTime istTime = startInstant.atZone(istZone);

    Date date = Date.from(istTime.toInstant());
    // System.out.println("Date--------" + date);
    return date;
  }

  private Long calculateDuration(Spans span) {
    long covertedStartTime = Long.parseLong(span.getStartTimeUnixNano(), 10);
    long convertedEndTime = Long.parseLong(span.getEndTimeUnixNano(), 10);

    Date startTime = new Date(covertedStartTime / 1000000);
    Date endTime = new Date(convertedEndTime / 1000000);

    // Calculate the duration in milliseconds
    long duration = endTime.getTime() - startTime.getTime();

    // System.out.println("-----------duration:------------- " + duration);
    return duration;
  }

  // extraction and marshelling of data and persistance for trace
  private List<TraceDTO> extractAndMapData(OtelTrace trace) {
    List<TraceDTO> traceDTOs = new ArrayList<>();

    try {
        for (ResourceSpans resourceSpans : trace.getResourceSpans()) {
            String serviceName = getServiceName(resourceSpans);

            List<String> traceIdList = new ArrayList<>();

            for (ScopeSpans scopeSpans : resourceSpans.getScopeSpans()) {
                List<Spans> spans = scopeSpans.getSpans();

                for (Spans span : spans) {
                    String traceId = span.getTraceId();

                    if (!traceIdList.contains(traceId)) {
                        traceIdList.add(traceId);
                    }
                }
            }

            for (String traceIdLoop : traceIdList) {
                TraceDTO traceDTO = new TraceDTO();
                List<Spans> objectList = new ArrayList<>();

                for (ScopeSpans scopeSpans : resourceSpans.getScopeSpans()) {
                    List<Spans> spans = scopeSpans.getSpans();

                    for (Spans span : spans) {
                        String traceId = span.getTraceId();

                        if (traceId.contains(traceIdLoop)) {
                            traceDTO.setServiceName(serviceName);
                            traceDTO.setTraceId(traceId);

                            if (span.getParentSpanId() == null || span.getParentSpanId().isEmpty()) {
                                traceDTO.setOperationName(span.getName());
                                traceDTO.setCreatedTime(calculateCreatedTime(span));
                                traceDTO.setDuration(calculateDuration(span));

                                // Check for "http.status_code" attribute
                                List<Attributes> attributes = span.getAttributes();
                                for (Attributes attribute : attributes) {
                                    if ("http.method".equals(attribute.getKey()) || "http.request.method".equals(attribute.getKey())) {
                                        traceDTO.setMethodName(attribute.getValue().getStringValue());
                                        System.out.println("http method ----------------"+traceDTO.getMethodName());
                                    }else{
                                        // System.out.println("Invallid attributes");
                                    }
                                    if ("http.status_code".equals(attribute.getKey()) || "http.response.status_code".equals(attribute.getKey())) {
                                        String statusCodeString = attribute.getValue().getIntValue();

                                        if (statusCodeString != null) {
                                            try {
                                                Long statusCode = Long.parseLong(statusCodeString);
                                                traceDTO.setStatusCode(statusCode);
                                                System.out.println("Status Code stored successfully: " + statusCode);
                                            } catch (NumberFormatException e) {
                                                System.err.println("Failed to parse status code: " + statusCodeString);
                                                e.printStackTrace();
                                            }
                                          
                                        } else {
                                            System.err.println("Status code is null. Cannot parse.");
                                        }
                                    }
                                }
                            } else {
                                // Code to handle when span.getParentSpanId() is not empty (if needed)
                            }
                            objectList.add(span);
                            traceDTO.setSpanCount(String.valueOf(objectList.size()));
                            traceDTO.setSpans(objectList);
                        }
                    }
                }
                traceDTOs.add(traceDTO);
                traceQueryRepo.persist(traceDTOs);
                // System.out.println("TraceDto: " + traceDTO.toString());
            }
        }
        return traceDTOs;
    } catch (Exception e) {
        e.printStackTrace();
        return traceDTOs;
    }
}

  // get all trace data
  public List<OtelTrace> getTraceProduct(OtelTrace trace) {
    return traceCommandRepo.listAll();
}
}