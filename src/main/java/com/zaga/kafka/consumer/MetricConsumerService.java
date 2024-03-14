package com.zaga.kafka.consumer;

import com.zaga.entity.otelmetric.OtelMetric;
import com.zaga.handler.MetricCommandHandler;

import jakarta.inject.Inject;


import org.eclipse.microprofile.reactive.messaging.Incoming;

public class MetricConsumerService {

  @Inject
  MetricCommandHandler metricCommandHandler;

  @Incoming("metric-in")
  public void consumeMetricDetails(OtelMetric metrics) {
    System.out.println("consumed metric data----------------");
    if (metrics != null) {
      metricCommandHandler.createMetricProduct(metrics);
    } else {
      System.out.println("Received null message. Check serialization/deserialization.");
    }
  }

  public static void main(String[] args) {
    // Gson gson = new Gson();

    // File file = new File("./src/main/java/com/zaga/kafka/consumer/MetricSample.json");

    // try (Reader reader1 = new FileReader(file)) {

    //   OtelMetric apmMetric = gson.fromJson(reader1, OtelMetric.class);

    //   MetricCommandHandler metricCommandHandler = new MetricCommandHandler();

    //   List<MetricDTO> apmMetricDTOs = metricCommandHandler.extractAndMapData(apmMetric);

    //   System.out.println("---------------------------------MAIN METHOD------------------------------");

    //   System.out.println(apmMetricDTOs.size());

    //   for (MetricDTO metricDTO : apmMetricDTOs) {
    //     // System.out.println("Metric DTOS " + metricDTO.toString());
    //     metricCommandHandler.processRuleManipulation(metricDTO);
    //     // break;
    //   }

    // } catch (IOException e) {
    //   System.out.println("ERROR " + e.getLocalizedMessage());
    // }
  }

}
