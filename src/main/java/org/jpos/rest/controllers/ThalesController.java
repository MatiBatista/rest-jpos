package org.jpos.rest.controllers;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.rest.dtos.request.CheckCardEligibilityRequestDTO;
import org.jpos.rest.dtos.request.SendOTPRequestDTO;
import org.jpos.rest.dtos.response.CardDigitalizationResponseDTO;
import org.jpos.rest.dtos.response.CheckCardEligibilityResponseDTO;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.utils.RestSupport;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class ThalesController extends RestSupport implements ThalesControllerDelegate {


    private ThalesService thalesService;

    @Inject
    public ThalesController(ThalesService thalesService) {
        this.thalesService = thalesService;
    }


    @Override
    public Response checkCardEligibility(String xCorrelationId, String xIssuerId, CheckCardEligibilityRequestDTO checkCardEligibilityRequestDTO) {

        CheckCardEligibilityResponseDTO checkCardEligibilityResponseDTO=thalesService.checkCardEligibility(checkCardEligibilityRequestDTO);

        return Response.ok(checkCardEligibilityRequestDTO, MediaType.APPLICATION_JSON).build();
    }


    @Override
    public Response requestCardDigitization(String xCorrelationId, String xIssuerId, CardDigitizationRequestDTO cardDigitizationRequestDTO) {

        CardDigitalizationResponseDTO cardDigitalizationResponseDTO=thalesService.requestCardDigitization(cardDigitizationRequestDTO);

        return Response.ok(cardDigitalizationResponseDTO,MediaType.APPLICATION_JSON).build();
    }


    @Override
    public Response sendOTP(String xCorrelationId, String xIssuerId, SendOTPRequestDTO sendOTPRequestDTO) {

        thalesService.sendOTP(sendOTPRequestDTO);

        return Response.ok().build();
    }
}