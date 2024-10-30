package org.jpos.rest.services.contracts;

import org.glassfish.jersey.spi.Contract;
import org.jpos.rest.dtos.response.EchoResponseDTO;
import org.jpos.rest.participants.Prueba;

import javax.ws.rs.core.Response;


@Contract
public interface EchoService {

    EchoResponseDTO echo();
}
