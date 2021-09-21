package org.miles;

import javax.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import org.eclipse.microprofile.openapi.annotations.servers.ServerVariable;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
        info = @Info(
            description = "This is a backend of a Logistics application REST",
            title = "Miles Logistics API",
            version = "1.0.0"
        ),
        tags = {
            @Tag(name = "Account", description = "Operations related to user Acount."),
            @Tag(name = "Login", description = "Operations related to login.")    
        },
        servers = {
            @Server(
                description = "Development Server",
                url = "http://{host}:{port}",
                variables = {
                    @ServerVariable(name = "host", defaultValue = "localhost"),
                    @ServerVariable(name = "port", defaultValue = "8080")
                }
            )
        }
)
public class MilesApplication extends Application{
    
}
