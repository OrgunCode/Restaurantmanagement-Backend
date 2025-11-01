/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import de.restaurant.restaurantserver.core.usecases.IBenutzerEinloggen;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 *
 * @author orgun
 */
@Path("/")
public class ServicesLogin {
    
    @EJB private IBenutzerEinloggen benutzerEinloggen;
    
    @GET
    @Path("/login/{benutzererkennung}/{passwort}")
    @Consumes ("text/plain")
    @Produces({MediaType.TEXT_PLAIN})
    public String login(@PathParam("benutzererkennung") String benutzererkennung,@PathParam("passwort") String passwort ) {
        if (benutzerEinloggen.login(benutzererkennung, passwort))
            return "true";
        else
            return "false";

    }
    
}
