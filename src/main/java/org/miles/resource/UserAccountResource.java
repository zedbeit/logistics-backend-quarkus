package org.miles.resource;

import io.vertx.core.json.JsonObject;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.hibernate.annotations.SourceType;
import org.miles.domain.GeneralUser;
import org.miles.repository.GeneralUserRepository;
import org.miles.security.service.TokenService;
import org.miles.service.UserAccountService;
import org.miles.service.dto.UserAccountDTO;
import org.miles.service.dto.vm.UserAccountVM;

@Path("account")
@Tag(ref = "Account")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserAccountResource {
    @Inject
    UserAccountService userAccountService;
    
    @Inject
    TokenService ts;
    
    @Inject
    GeneralUserRepository generalUserRepository;
    
    @GET
    @Path("/test")
    public Response testEndpoint(){
        
//        JsonObject token = ts.generateToken("zaheedbeita@gmail.com",new HashSet<>(Arrays.asList("User", "Admin")));
//        ts.generateToken("Zaheedbeita@gmail.com", new HashSet<>(Arrays.asList("User", "Admin")));
//        return Response.ok(token).build();

        return Response.ok("Testing").build();
    }    
    
    @POST
    @Operation(summary = "Sign up endpoint for General user.")
    @APIResponse(responseCode = "200", description = "returns a User Account DTO.")
    @Path("/generaluser-signup")
    public Response signUpForUser(UserAccountVM userAccountVM) {
        UserAccountDTO userAccount = userAccountService.createGeneralUser(userAccountVM);
        return Response.status(Response.Status.CREATED).entity(userAccount).build();
    }
    
    @POST
    @Operation(summary = "Sign up endpoint for company.")
    @APIResponse(responseCode = "200", description = "returns a User Account DTO.")
    @Path("/company-signup")
    public Response signUpForCompany(UserAccountVM userAccountVM) {
        UserAccountDTO userAccount = userAccountService.createCompany(userAccountVM);
        return Response.status(Response.Status.CREATED).entity(userAccount).build();
    }
}
