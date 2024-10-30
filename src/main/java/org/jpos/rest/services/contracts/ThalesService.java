package org.jpos.rest.services.contracts;

import org.glassfish.jersey.spi.Contract;
import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.rest.dtos.request.CheckCardEligibilityRequestDTO;
import org.jpos.rest.dtos.request.SendOTPRequestDTO;
import org.jpos.rest.dtos.response.CardDigitalizationResponseDTO;
import org.jpos.rest.dtos.response.CheckCardEligibilityResponseDTO;

@Contract
public interface ThalesService {
    CardDigitalizationResponseDTO requestCardDigitization(CardDigitizationRequestDTO cardDigitizationRequestDTO) throws Exception;

    CheckCardEligibilityResponseDTO checkCardEligibility(CheckCardEligibilityRequestDTO checkCardEligibilityRequestDTO) throws Exception;

    void sendOTP(SendOTPRequestDTO sendOTPRequestDTO) throws Exception;
}
