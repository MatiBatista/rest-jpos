package org.jpos.rest.controllers;



import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.jpos.rest.dtos.request.CardDigitizationRequestDTO;
import org.jpos.rest.services.contracts.ThalesService;
import org.jpos.rest.utils.RestSupport;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
    @Path("/requestCardDigitization")
    @Operation(summary = "Post request card digitization",
            responses = {
            @ApiResponse(responseCode = "200", description = "Solicitud procesada exitosamente."),
            @ApiResponse(responseCode  = "400", description = "Solicitud incorrecta, URI de solicitud o encabezado inválido, o parámetro no estándar no compatible."),
            @ApiResponse(responseCode  = "500",description = "Error interno del servidor.")
    })
    public Response requestCardDigitization(  @RequestBody(
            description = "Request Card Digitization",
            required = true,
            content = @Content(schema = @Schema(implementation = CardDigitizationRequestDTO.class))
    ) CardDigitizationRequestDTO cardDigitizationRequestDTO) {
        thalesService.requestCardDigitization(cardDigitizationRequestDTO);
        return Response.ok(cardDigitizationRequestDTO,MediaType.APPLICATION_JSON) .status(Response.Status.OK)
                .build();
    }
}
