package org.miles.lang.exception;

import javax.ws.rs.BadRequestException;

public class CompanyAlreadyExistException extends BadRequestException {
    public CompanyAlreadyExistException(String message){
        super(message);
    }

    public CompanyAlreadyExistException(){
        super("COMPANY_ALREADY_EXIST");
    }
}
