package org.miles.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.miles.service.UserAccountService;
import org.miles.service.dto.CompanyDTO;
import org.miles.service.dto.UserAccountDTO;
import org.miles.service.dto.vm.CompanyVM;
import org.miles.service.dto.vm.UserAccountVM;

@Path("account")
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
    @Path("/generaluser-signup")
    public Response signUpForUser(UserAccountVM userAccount) {
        UserAccountDTO user = userAccountService.createGeneralUser(userAccount);
        return Response.status(Response.Status.CREATED).entity(user).build();
    }
    
    @POST
    @Path("/company-signup")
    public Response signUpForCompany(CompanyVM companyVM) {
        CompanyDTO company = userAccountService.createCompany(companyVM);
        return Response.status(Response.Status.CREATED).entity(company).build();
    }
}
