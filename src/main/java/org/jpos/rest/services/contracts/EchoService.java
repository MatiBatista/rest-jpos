package org.jpos.rest.services.contracts;

import org.glassfish.jersey.spi.Contract;

import javax.ws.rs.core.Response;


@Contract
public interface EchoService {

    Response echo(String message);
    Response echo();
}
