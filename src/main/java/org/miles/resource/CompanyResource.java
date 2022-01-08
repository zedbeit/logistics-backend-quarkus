package org.miles.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.miles.service.CompanyService;

@Path("api/v1/company")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompanyResource {
    
    @Inject
    CompanyService companyService;

    @GET
    @Path("/add-location/{companyId}")
    public Response addLocation(@PathParam("companyId") Long companyId, @QueryParam("location") String location){
        companyService.addLocation(companyId, location);
        return Response.ok().build();
    }

    @GET
    @Path("/add-route/{companyId}/{locationId}")
    public Response addRoute(@PathParam("companyId") Long companyId, @PathParam("locationId") Long locationId, @QueryParam("route") String route){
        companyService.addRoute(companyId, locationId, route);        
        return Response.ok().build();
    }
}
