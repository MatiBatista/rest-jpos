package org.jpos.rest.controllers;

import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;


@ApplicationPath("/api")
public class EndpointConfig extends ResourceConfig {

    public EndpointConfig() {
        packages("org.jpos.rest.controllers");
    }
}
