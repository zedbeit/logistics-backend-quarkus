package org.miles.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.miles.lang.exception.PreconditionFailedException;
import org.miles.repository.UserAccountRepository;

@RequestScoped
public class LoginService {
    private Logger LOGGER = Logger.getLogger(LoginService.class);
    
    @Inject
    UserAccountRepository userAccountRepository;
    
    public Response login(String username, String password ) {
        
        if (username == null || username.isBlank() || password == null || password.isBlank()) {
            throw new PreconditionFailedException("Username and Password are required");
        }
        
        
        return null;
    }
}

