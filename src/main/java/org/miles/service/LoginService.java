package org.miles.service;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.Response;
import org.jboss.logging.Logger;

@RequestScoped
public class LoginService {
    private Logger LOGGER = Logger.getLogger(LoginService.class);
    
    public Response login(String username, String password ) {
        return null;
    }
}

