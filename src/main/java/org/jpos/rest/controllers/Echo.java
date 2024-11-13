package org.jpos.rest.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import org.jpos.rest.services.contracts.EchoService;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//@Tag(name = "Echo")
@Path("/echo")
public class Echo {

    /*@Inject
    private EchoService echoService;*/

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response echo() {
        System.out.println("entraaaaaaaaaaaa");
       return Response.ok().build();
    }

}