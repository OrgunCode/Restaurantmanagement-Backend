/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.usecases.IStornierungenAuswerten;
import de.restaurant.restaurantserver.core.usecases.ITischPflegen;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author orgun
 */
@Path("/")
public class ServicesManager {
    
    @EJB private ITischPflegen tischPflegen;
    @EJB private IStornierungenAuswerten reservierungStornierungSuchen;
    
 
    @GET
    @Path("/manager")
    @Produces({MediaType.TEXT_PLAIN})
    public String explain() {
        return "API fuer die Manager-Schnittstelle eines Restaurants. "
                + "Zugriff besteht auf die Ressource restaurant/manager/tischPflegen "
                + "und restaurant/manager/reservierungStornierung";
    }
    
    
    @POST
    @Path("/manager/tischPflegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createTisch(TischTO tischTO, @Context UriInfo uriInfo ) {

        Tisch tisch 
                = tischPflegen.tischAnlegen(
                        tischTO.nummer() 
                        , tischTO.anzahlPlaetze()
                        , tischTO.lage() 
                        , tischTO.tischstatus()
                        );
        
        if (tisch == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(tisch.getNummer()));
            return Response.created(uriBuilder.build()).build();
        }
    }
        
        
    @PUT
    @Path("/manager/tischPflegen/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateTisch(TischTO tischTO ) {
        
        if (tischPflegen.tischAendern(
                        tischTO.nummer() 
                        , tischTO.anzahlPlaetze()
                        , tischTO.lage()
                        , tischTO.tischstatus() 
                ))
            return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.CONFLICT).build(); 
        }
    }
    
    
    @GET
    @Path("/manager/reservierungStornierung")
    @Produces({MediaType.APPLICATION_JSON}) 
    public ReservierungTOList allReservierungStornierung() {
            
        List<Reservierung> liste = reservierungStornierungSuchen.reservierungStornierungenAuswerten();

        ReservierungTOList listeTO;
        if (!liste.isEmpty()) {
            listeTO = new ReservierungTOList( 
                liste.stream()
                .map(ReservierungTO::fromDomain)
                .collect(Collectors.toList())
            );
        }
        
        else {
            listeTO = new ReservierungTOList(null);
        }

        return listeTO;	
    }
    
    
}
