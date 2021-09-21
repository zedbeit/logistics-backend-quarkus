package org.miles.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
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
    
    @GET
    @Path("/test")
    public Response testEndpoint(){
        return Response.ok("Working").build();
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
