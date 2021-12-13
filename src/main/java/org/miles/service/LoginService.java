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
import org.miles.security.service.SecurityUtils;

@RequestScoped
public class LoginService {
    private Logger LOGGER = Logger.getLogger(LoginService.class);
    
    @Inject
    UserAccountRepository userAccountRepository;
    
    @Inject
    SecurityUtils securityUtils; 
    
    public Response login(String email, String plainTextPassword) {
        
        if (email == null || email.isBlank() || plainTextPassword == null || plainTextPassword.isBlank()) {
            throw new PreconditionFailedException("Email and Password are required");
        }
        Optional<UserAccount> user = userAccountRepository.findActiveUserAccountByEmail(email);
        
        if (user.isEmpty()) {
            throw new UnAuthorizedException("Invalid email");
        }
        
        UserAccount userAccount = user.get();
        
        if(!securityUtils.passwordsMatch(userAccount.password, userAccount.secretKey, plainTextPassword)){
            throw new UnAuthorizedException("Password is incorrect");
        }
        return Response.ok(new UserAccountRepresentation(userAccount)).build();
    }
}

