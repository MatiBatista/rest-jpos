package org.jpos.rest.Exceptions.CustomExceptions;

public class ConflictException  extends RuntimeException{

    public ConflictException(String message){
        super(message);
    }
}
