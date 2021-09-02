package org.miles.lang.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import org.miles.lang.representation.BaseRepresentation;

public class PreconditionFailedExceptionMapper implements ExceptionMapper<PreconditionFailedException>{

    @Override
    public Response toResponse(PreconditionFailedException e) {
        return Response.status(Response.Status.BAD_REQUEST)
            .entity(new BaseRepresentation(e.getMessage(),Response.Status.BAD_REQUEST.getStatusCode()))
            .build();
    }
}
