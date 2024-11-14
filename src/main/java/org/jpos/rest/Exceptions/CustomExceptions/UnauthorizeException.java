package org.jpos.rest.Exceptions.CustomExceptions;

public class UnauthorizeException extends RuntimeException{
    public UnauthorizeException(String message){
        super(message);
    }
}