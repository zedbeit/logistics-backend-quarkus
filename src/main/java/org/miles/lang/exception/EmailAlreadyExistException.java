package org.miles.lang.exception;

import javax.ws.rs.BadRequestException;

public class EmailAlreadyExistException extends BadRequestException {
    public EmailAlreadyExistException(String message){
        super(message);
    }

    public EmailAlreadyExistException(){
        super("EMAIL_ALREADY_EXIST");
    }
}
