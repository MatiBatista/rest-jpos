package org.jpos.rest.dtos.response;

public class EchoResponseDTO {

    private String message;


    public EchoResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
