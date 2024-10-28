package org.jpos.rest.services.contracts;

import org.glassfish.jersey.spi.Contract;
import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;

@Contract
public interface ThalesService {
    void requestCardDigitization(CardDigitizationRequestDTO cardDigitizationRequestDTO);
}
