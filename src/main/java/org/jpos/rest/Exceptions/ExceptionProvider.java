package org.jpos.rest.Exceptions;

import org.eclipse.jetty.http.HttpStatus;
import org.jpos.rest.Exceptions.CustomExceptions.BadRequestException;
import org.jpos.rest.Exceptions.CustomExceptions.ConflictException;
import org.jpos.rest.Exceptions.CustomExceptions.NotFoundException;
import org.jpos.rest.Exceptions.CustomExceptions.UnauthorizeException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionProvider implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable exception) {

        //404
        if(exception instanceof NotFoundException)
            return Response.status(HttpStatus.NOT_FOUND_404)
                    .entity(exception.getMessage())
                    .build();

        //400
        if(exception instanceof BadRequestException)
            return Response.status(HttpStatus.BAD_REQUEST_400)
                    .entity(exception.getMessage())
                    .build();

        //409
        if(exception instanceof ConflictException)
            return Response.status(HttpStatus.CONFLICT_409)
                    .entity(exception.getMessage())
                    .build();

        //401
        if(exception instanceof UnauthorizeException)
            return Response.status(HttpStatus.UNAUTHORIZED_401)
                    .entity(exception.getMessage())
                    .build();

        return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
    }
}