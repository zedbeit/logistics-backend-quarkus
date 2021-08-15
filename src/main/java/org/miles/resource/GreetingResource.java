package org.miles.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;


@Path("/hello")
public class GreetingResource {
    private Logger LOGGER = Logger.getLogger(GreetingResource.class);
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        LOGGER.info("This endpoint is for testing purpose.");
        return "Hello RESTEasy";
    }
}