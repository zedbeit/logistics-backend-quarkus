package org.miles.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.miles.domain.Authority;
import org.miles.domain.UserAccount;
import org.miles.lang.exception.PreconditionFailedException;
import org.miles.lang.exception.UnAuthorizedException;
import org.miles.lang.representation.UserAccountRepresentation;
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
        
        Optional<UserAccount> user = userAccountRepository.findActiveUserAccountByEmailAndPassword(username, password);
        if (user.isEmpty()) {
            throw new UnAuthorizedException("Invalid username or password");
        }
        
        UserAccount userAccount = user.get();
        
        return Response.ok(new UserAccountRepresentation(userAccount)).build();
    }
}

