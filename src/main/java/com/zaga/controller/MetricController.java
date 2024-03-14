package com.zaga.controller;


import com.zaga.entity.otelmetric.OtelMetric;
import com.zaga.handler.MetricCommandHandler;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/metrics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MetricController {

    @Inject
    MetricCommandHandler metricCommandHandler;

   
    @POST
    @Path("/create")
    public Response createProduvct(OtelMetric metric) {
        try {
            //System.out.println("----------------");
            metricCommandHandler.createMetricProduct(metric);
            return Response.status(200).entity(metric).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }


    
}
