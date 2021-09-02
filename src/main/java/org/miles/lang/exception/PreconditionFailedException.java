package org.miles.lang.exception;

import javax.ws.rs.BadRequestException;

public class PreconditionFailedException extends BadRequestException {
    public PreconditionFailedException() {
        super("PRECONDITION_FAILED_EXCEPTION");
    }

    public PreconditionFailedException(String message) {
        super(message);
    }
}
