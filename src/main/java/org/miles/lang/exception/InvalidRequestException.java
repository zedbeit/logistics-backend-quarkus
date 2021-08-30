package org.miles.lang.exception;

import javax.ws.rs.BadRequestException;

/**
 * 
 * @author miles-team
 */

public class InvalidRequestException extends BadRequestException {
    public InvalidRequestException(){
        super("INVALID_REQUEST_EXCEPTION");
    }

    public InvalidRequestException(String message){
        super(message);
    }
}
