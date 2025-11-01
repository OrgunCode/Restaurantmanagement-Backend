package de.restaurant.restaurantserver;

import jakarta.annotation.security.DeclareRoles;
import jakarta.security.enterprise.authentication.mechanism.http.BasicAuthenticationMechanismDefinition;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */

@BasicAuthenticationMechanismDefinition
        (realmName = "basicAuth")

@DeclareRoles
        ({ "benutzer" })

@ApplicationPath("/restapi")
public class JakartaRestConfiguration extends Application {
    
}
