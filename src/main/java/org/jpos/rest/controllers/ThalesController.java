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

@Path("/")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
@Tag(name = "ThalesController")
public class ThalesController extends RestSupport {

    @Inject
    private ThalesService thalesService;

    @POST
    @Path("/checkCardEligibility")
    @Operation(summary = "Post check card is eligibile to digitization",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Solicitud procesada exitosamente."),
                    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, URI de solicitud o encabezado inválido, o parámetro no estándar no compatible."),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
            })
    public Response checkCardEligibility(@HeaderParam("x-correlation-id") String xCorrelationId,
                                         @HeaderParam("x-issuer-id") String xIssuerId,
                                         @RequestBody(
                                                 description = "Request Card Digitization",
                                                 required = true,
                                                 content = @Content(schema = @Schema(implementation = CheckCardEligibilityRequestDTO.class))
                                         ) CheckCardEligibilityRequestDTO checkCardEligibilityRequestDTO) {
        CheckCardEligibilityResponseDTO checkCardEligibilityResponseDTO=thalesService.checkCardEligibility(checkCardEligibilityRequestDTO);
        return Response.ok(checkCardEligibilityRequestDTO, MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/requestCardDigitization")
    @Operation(summary = "Post request card digitization",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Solicitud procesada exitosamente."),
                    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, URI de solicitud o encabezado inválido, o parámetro no estándar no compatible."),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
            })
    public Response requestCardDigitization(@HeaderParam("x-correlation-id") String xCorrelationId,
                                            @HeaderParam("x-issuer-id") String xIssuerId,
                                            @RequestBody(
                                                    description = "Request Card Digitization",
                                                    required = true,
                                                    content = @Content(schema = @Schema(implementation = CardDigitizationRequestDTO.class))
                                            ) CardDigitizationRequestDTO cardDigitizationRequestDTO) {
        CardDigitalizationResponseDTO cardDigitalizationResponseDTO=thalesService.requestCardDigitization(cardDigitizationRequestDTO);
        return Response.ok(cardDigitalizationResponseDTO,MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("/sendOTP")
    @Operation(summary = "Post provides ID&V OTP",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Solicitud procesada exitosamente."),
                    @ApiResponse(responseCode = "400", description = "Solicitud incorrecta, URI de solicitud o encabezado inválido, o parámetro no estándar no compatible."),
                    @ApiResponse(responseCode = "500", description = "Error interno del servidor.")
            })
    public Response sendOTP(@HeaderParam("x-correlation-id") String xCorrelationId,
                                            @HeaderParam("x-issuer-id") String xIssuerId,
                                            @RequestBody(
                                                    description = "Request Card Digitization",
                                                    required = true,
                                                    content = @Content(schema = @Schema(implementation = SendOTPRequestDTO.class))
                                            )SendOTPRequestDTO sendOTPRequestDTO) {
        thalesService.sendOTP(sendOTPRequestDTO);
        return Response.ok().build();
    }



}