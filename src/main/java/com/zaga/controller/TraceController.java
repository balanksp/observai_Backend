package com.zaga.controller;


import com.zaga.entity.oteltrace.OtelTrace;
import com.zaga.handler.TraceCommandHandler;
import com.zaga.repo.TraceQueryRepo;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/traces")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TraceController {

    @Inject
    TraceCommandHandler traceCommandHandler;

    @Inject
    TraceQueryRepo traceQueryRepo;
   
    @POST
    @Path("/create")
    public Response createProduvct(OtelTrace trace) {
        try {
            //System.out.println("----------------");
            traceCommandHandler.createTraceProduct(trace);
            return Response.status(200).entity(trace).build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }
    
}