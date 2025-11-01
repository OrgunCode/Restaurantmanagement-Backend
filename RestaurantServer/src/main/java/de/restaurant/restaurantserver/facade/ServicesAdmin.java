/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import de.restaurant.restaurantserver.core.entities.Benutzer;
import de.restaurant.restaurantserver.core.usecases.IBenutzerPflegen;
import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import jakarta.ws.rs.core.UriInfo;

/**
 *
 * @author orgun
 */
public class ServicesAdmin {
    
    @EJB private IBenutzerPflegen adminPflegen;
    @EJB private IBenutzerPflegen managerPflegen;
    @EJB private IBenutzerPflegen mitarbeiterPflegen;

    
    @GET
    @Path("/admin")
    @Produces({MediaType.TEXT_PLAIN})
    public String explain() {
        return "API fuer die Admin-Schnittstelle eines Restaurants. "
                + "Zugriff besteht auf die Ressource restaurant/admin/adminPflegen,"
                + "restaurant/admin/managerPflegen und restaurant/admin/mitarbeiterPflegen, "
                + "restaurant/admin/adminPflegen/ und restaurant/admin/managerPflegen/";
    }
    
    
    @POST
    @Path("/admin/adminPflegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createAdmin(AdminTO adminTO, @Context UriInfo uriInfo ) {

        Benutzer admin 
                = adminPflegen.adminAnlegen(
                        adminTO.benutzererkennung() 
                        , adminTO.passwort()
                        , adminTO.name()
                        , adminTO.telefonnummer()                        
                        );
        
        if (admin == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(admin.getBenutzererkennung());
            return Response.created(uriBuilder.build()).build();
        }
    }
    
    
    @POST
    @Path("/admin/managerPflegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createManager(ManagerTO managerTO, @Context UriInfo uriInfo ) {

        Benutzer manager 
                = managerPflegen.managerAnlegen(
                        managerTO.benutzererkennung() 
                        , managerTO.passwort()
                        , managerTO.name()
                        , managerTO.telefonnummer()
                        , managerTO.tischnr()
                        );
        
        if (manager == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(manager.getBenutzererkennung());
            return Response.created(uriBuilder.build()).build();
        }
    }
    
        
    @POST
    @Path("/admin/mitarbeiterPflegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createMitarbeiter(MitarbeiterTO mitarbeiterTO, @Context UriInfo uriInfo ) {

        Benutzer mitarbeiter 
                = mitarbeiterPflegen.mitarbeiterAnlegen(
                        mitarbeiterTO.benutzererkennung() 
                        , mitarbeiterTO.passwort()
                        , mitarbeiterTO.name()
                        , mitarbeiterTO.telefonnummer()
                        , mitarbeiterTO.gastnr()
                        );
        
        if (mitarbeiter == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(mitarbeiter.getBenutzererkennung());
            return Response.created(uriBuilder.build()).build();
        }
    }
    
    
    @PUT
    @Path("/admin/adminPflegen/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateAdmin(AdminTO adminTO ) {
        
        if (adminPflegen.adminAendern(
                adminTO.benutzererkennung()
                ,adminTO.passwort()
                ,adminTO.name()
                ,adminTO.telefonnummer()
                ))
            return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.CONFLICT).build(); 
        }
    }

  
    @PUT
    @Path("/admin/managerPflegen/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateManager(ManagerTO managerTO ) {
        
        if (managerPflegen.managerAendern(
                managerTO.benutzererkennung()
                ,managerTO.passwort()
                ,managerTO.name()
                ,managerTO.telefonnummer()
                ,managerTO.tischnr()
                ))
            return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.CONFLICT).build(); 
        }
    }
    
    
    @PUT
    @Path("/admin/mitarbeiterPflegen/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateMitarbeiter(MitarbeiterTO mitarbeiterTO ) {
        
        if (mitarbeiterPflegen.mitarbeiterAendern(
                mitarbeiterTO.benutzererkennung()
                ,mitarbeiterTO.passwort()
                ,mitarbeiterTO.name()
                ,mitarbeiterTO.telefonnummer()
                ,mitarbeiterTO.gastnr()
                ))
            return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.CONFLICT).build(); 
        }
    }
    
        
}
