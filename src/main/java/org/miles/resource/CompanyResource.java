package org.miles.resource;

import org.miles.service.CompanyService;
import org.miles.service.dto.CompanyDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyResource {
    
    @Inject
    CompanyService companyService;

    @POST
    @Path("add-location/{companyId}")
    public Response addLocation(@PathParam("companyId") Long companyId,
                            @QueryParam("location") String location){
        companyService.addLocation(companyId,location);
        return Response.ok().build();
    }

    @POST
    @Path("add-route/{companyId}")
    public Response addRoute(@PathParam("companyId") Long companyId,
                            @QueryParam("location") String location,
                            @QueryParam("route") String route){
        companyService.addRoute(companyId, location, route);        
        return Response.ok().build();
    }

    @GET
    @Path("get-companies")
    public Response getCompaniesWithMatchingRoute(
            @QueryParam("location") String location,
            @QueryParam("src") String src,
            @QueryParam("dest") String dest){
        List<CompanyDTO> companies = companyService.getCompaniesWithMatchingRoute(location, src, dest);
        return Response.ok().entity(companies).build();
    }
}
