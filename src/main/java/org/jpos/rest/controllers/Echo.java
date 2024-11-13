package org.jpos.rest.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jpos.rest.services.contracts.EchoService;




//@Tag(name = "Echo")
@Path("/echo")
public class Echo {

    /*@Inject
    private EchoService echoService;*/

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response echo() {
        System.out.println("entraaaaaaaaaaaa");
       return Response.ok("bautista").build();
    }

}