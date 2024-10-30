package org.jpos.rest.Exceptions.CustomExceptions;

import org.jpos.rest.dtos.Enum.Thales_Response_Status;

import org.jpos.rest.dtos.response.ErrorResponseDTO;

//400
public class BadRequestException extends RuntimeException{

    private ErrorResponseDTO errorResponseDTO;

    public BadRequestException(Thales_Response_Status status){
        super(status.getMessage());
        errorResponseDTO = new ErrorResponseDTO(status.getCode(),status.getMessage(),"400");
    }

    public ErrorResponseDTO getErrorResponseDTO() {
        return errorResponseDTO;
    }
}
