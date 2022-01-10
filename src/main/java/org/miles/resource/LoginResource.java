package org.miles.resource;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.miles.service.LoginService;
import org.miles.service.dto.LoginDTO;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("auth")
@Tag(ref = "Login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginResource {
    
    @Inject
    LoginService loginService;
    
    @POST
    @Operation(summary = "Login endpoint.")
    @APIResponse(responseCode = "200", description = "returns a User Representation.")
    @Path("login")
    public Response login(LoginDTO loginDTO){

        return loginService.login(loginDTO.username,loginDTO.password);
    }
}
