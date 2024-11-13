package org.jpos.rest.controllers;





import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.rest.dtos.request.CheckCardEligibilityRequestDTO;
import org.jpos.rest.dtos.request.SendOTPRequestDTO;
import org.jpos.rest.dtos.response.CardDigitalizationResponseDTO;
import org.jpos.rest.dtos.response.CheckCardEligibilityResponseDTO;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.utils.RestSupport;


public class ThalesController extends RestSupport implements ThalesControllerDelegate {


    private ThalesService thalesService;

    @Inject
    public ThalesController(ThalesService thalesService) {
        this.thalesService = thalesService;
    }


    @Override
    public Response checkCardEligibility(String xCorrelationId, String xIssuerId, CheckCardEligibilityRequestDTO checkCardEligibilityRequestDTO) throws Exception {

        CheckCardEligibilityResponseDTO checkCardEligibilityResponseDTO=thalesService.checkCardEligibility(checkCardEligibilityRequestDTO);

        return Response.ok(checkCardEligibilityRequestDTO, MediaType.APPLICATION_JSON).build();
    }


    @Override
    public Response requestCardDigitization(String xCorrelationId, String xIssuerId, CardDigitizationRequestDTO cardDigitizationRequestDTO) throws Exception {

        CardDigitalizationResponseDTO cardDigitalizationResponseDTO=thalesService.requestCardDigitization(cardDigitizationRequestDTO);

        return Response.ok(cardDigitalizationResponseDTO,MediaType.APPLICATION_JSON).build();
    }


    @Override
    public Response sendOTP(String xCorrelationId, String xIssuerId, SendOTPRequestDTO sendOTPRequestDTO) throws Exception {

        thalesService.sendOTP(sendOTPRequestDTO);

        return Response.ok().build();
    }
}