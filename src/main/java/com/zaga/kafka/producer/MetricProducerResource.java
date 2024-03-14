// package com.zaga.kafka.producer;


// import com.zaga.entity.otelmetric.OtelMetric;


// import jakarta.ws.rs.core.Response;
// import jakarta.inject.Inject;
// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.core.MediaType;


// // @Path("/metricProducer")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class MetricProducerResource {
    
//     @Inject
//     private MetricProducerService metricProducerService;

//     @POST
//     public Response addProduct(OtelMetric otelMetric){
//         try {
//             metricProducerService.sendMetric(otelMetric);
//             return Response.status(200).entity(otelMetric).build();
//         } catch (Exception e) {
//             return Response.status(400).entity(e.getMessage()).build();
//         }

//     }
// }
