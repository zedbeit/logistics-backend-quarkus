package org.miles.lang.exception;

import java.util.HashMap;
import java.util.Map;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.miles.lang.representation.BaseRepresentation;

@Provider
public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException e) {
        final Map<String, String> constraintViolations = new HashMap<>();
    
        e.getConstraintViolations().forEach(cv -> {
            constraintViolations.put(cv.getPropertyPath().toString(), cv.getMessage());
        });
        
        return Response.status(Response.Status.PRECONDITION_FAILED)
            .entity(new BaseRepresentation(Response.Status.PRECONDITION_FAILED.getStatusCode(), constraintViolations))
            .build();
    }   
}
