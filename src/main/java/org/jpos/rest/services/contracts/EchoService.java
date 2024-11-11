package org.jpos.rest.services.contracts;

import org.glassfish.jersey.spi.Contract;
import org.jpos.rest.dtos.response.EchoResponseDTO;
import org.jpos.rest.participants.Prueba;




@Contract
public interface EchoService {

    EchoResponseDTO echo();
}
