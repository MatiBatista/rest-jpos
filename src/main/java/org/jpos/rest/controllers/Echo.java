package org.jpos.rest.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.jetty.ee10.annotations.AnnotationParser;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.jpos.rest.dtos.response.EchoResponseDTO;
import org.jpos.rest.services.contracts.EchoService;



@Tag(name = "Echo")
@Path("/echo")
public class Echo{

    @Inject
    private EchoService echoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response echo() {
        System.out.println("entraaaaaaaaaaaa");
       return Response.ok(echoService.echo()).build();
    }

}

