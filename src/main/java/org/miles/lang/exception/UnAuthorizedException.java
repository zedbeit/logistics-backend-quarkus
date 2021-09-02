package org.miles.lang.exception;

import io.quarkus.security.UnauthorizedException;

public class UnAuthorizedException extends UnauthorizedException{
    public UnAuthorizedException(){
        super("UNAUTHORIZED");
    }

    public UnAuthorizedException(String message){
        super(message);
    }
}
