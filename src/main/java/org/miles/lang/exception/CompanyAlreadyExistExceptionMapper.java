package org.miles.lang.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.miles.lang.representation.BaseRepresentation;

@Provider
public class CompanyAlreadyExistExceptionMapper implements ExceptionMapper<CompanyAlreadyExistException>{

    @Override
    public Response toResponse(final CompanyAlreadyExistException e) {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new BaseRepresentation(e.getMessage(),Response.Status.BAD_REQUEST.getStatusCode()))
            .build();
    }
}
