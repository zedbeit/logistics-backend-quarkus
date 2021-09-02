package org.miles.lang.exception;

import javax.ws.rs.BadRequestException;

public class InvalidRequestException extends BadRequestException {
    public InvalidRequestException(){
        super("INVALID_REQUEST_EXCEPTION");
    }

    public InvalidRequestException(String message){
        super(message);
    }
}
