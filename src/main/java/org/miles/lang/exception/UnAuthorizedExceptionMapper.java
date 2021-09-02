package org.miles.lang.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.miles.lang.representation.BaseRepresentation;

@Provider
public class UnAuthorizedExceptionMapper implements ExceptionMapper<UnAuthorizedException>{

    @Override
    public Response toResponse(UnAuthorizedException e) {
        return Response.status(Response.Status.UNAUTHORIZED)
            .entity(new BaseRepresentation(e.getMessage(),Response.Status.UNAUTHORIZED.getStatusCode()))
            .build();
    }
}
