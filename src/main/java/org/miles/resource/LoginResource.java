package org.miles.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.miles.service.LoginService;
import org.miles.service.dto.LoginDTO;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {
    
    @Inject
    LoginService loginService;
    
    @POST
    public Response login(LoginDTO loginDTO){
        return loginService.login(loginDTO.username,loginDTO.password);
    }
}
