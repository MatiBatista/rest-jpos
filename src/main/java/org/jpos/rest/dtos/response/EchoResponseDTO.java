package org.jpos.rest.dtos.response;

public class Prueba {

    private String message;


    public Prueba(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
