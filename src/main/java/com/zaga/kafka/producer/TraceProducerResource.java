// package com.zaga.kafka.producer;

// import com.zaga.entity.oteltrace.OtelTrace;

// import jakarta.enterprise.context.ApplicationScoped;
// import jakarta.inject.Inject;
// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.Response;

// @ApplicationScoped
// // @Path("/traceProducer")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class TraceProducerResource {
    
//     @Inject
//     private TraceProducerService traceProducerService;

//     @POST
//     public Response sendProductDetails(OtelTrace trace) {
//         traceProducerService.sendProductDetails(trace);
//         return Response.status(200).entity(trace).build();
//     }
    
// }
