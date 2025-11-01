/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.core.entities.Gast;
import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.usecases.IBestellungPflegen;
import de.restaurant.restaurantserver.core.usecases.IFreieTischeSuchen;
import de.restaurant.restaurantserver.core.usecases.IGastPflegen;
import de.restaurant.restaurantserver.core.usecases.IReservierungPflegen;
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
public class ServicesMitarbeiter {
    
    @EJB private IGastPflegen gastPflegen;
    @EJB private IReservierungPflegen reservierungPflegen;
    @EJB private IFreieTischeSuchen tischSuchen;
    @EJB private IBestellungPflegen bestellungPflegen;
    
    
    
    @GET
    @Path("/mitarbeiter")
    @Produces({MediaType.TEXT_PLAIN})
    public String explain() {
        return "API fuer die Mitarbeiter-Schnittstelle eines Restaurants. "
                + "Zugriff besteht auf die Ressource restaurant/mitarbeiter/gastPflegen, "
                + "restaurant/mitarbeiter/reservierungPflegen, restaurant/mitarbeiter/autor und "
                + "restaurant/mitarbeiter/bestellungPflegen";
    }
    
    
    @POST
    @Path("/mitarbeiter/gastPflegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createGast(GastTO gastTO, @Context UriInfo uriInfo ) {

        Gast gast 
                = gastPflegen.gastAnlegen(
                        gastTO.kundennummer() 
                        , gastTO.name()
                        , gastTO.strasse()
                        , gastTO.hausnummer()
                        , gastTO.plz()
                        , gastTO.ort()
                        , gastTO.land()
                        , gastTO.telefonnummer()
                        , gastTO.eMailAdresse()
                        , gastTO.geburtsdatum()
                        , gastTO.vorlieben()
                        , gastTO.reservierungsnr()
                        , gastTO.bestellungsnr()
                        );
        
        if (gast == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(gast.getKundennummer()));
            return Response.created(uriBuilder.build()).build();
        }
    }
        
        
    @PUT
    @Path("/mitarbeiter/gastPflegen/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateGast(GastTO gastTO ) {
        
        if (gastPflegen.gastAendern(
                gastTO.kundennummer() 
                        , gastTO.name()
                        , gastTO.strasse()
                        , gastTO.hausnummer()
                        , gastTO.plz()
                        , gastTO.ort()
                        , gastTO.land()
                        , gastTO.telefonnummer()
                        , gastTO.eMailAdresse()
                        , gastTO.geburtsdatum()
                        , gastTO.vorlieben()
                        , gastTO.reservierungsnr()
                        , gastTO.bestellungsnr()
                ))
            return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.CONFLICT).build(); 
        }
    }
    
    
    @POST
    @Path("/mitarbeiter/reservierungPflegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createReservierung(ReservierungTO reservierungTO, @Context UriInfo uriInfo ) {

        Reservierung reservierung 
                = reservierungPflegen.reservierungAnlegen(
                        reservierungTO.reservierungsnummer() 
                        , reservierungTO.reservierungsdatum()
                        , reservierungTO.reservierungsuhrzeit()
                        , reservierungTO.anzahlDerPersonen()
                        , reservierungTO.wunsch()
                        , reservierungTO.reservierungsstatus()
                        , reservierungTO.tischnr()
                        );
        
        if (reservierung == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(reservierung.getReservierungsnummer()));
            return Response.created(uriBuilder.build()).build();
        }
    }
	
	
    @PUT
    @Path("/mitarbeiter/reservierungPflegen/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateReservierung(ReservierungTO reservierungTO ) {
        
        if (reservierungPflegen.reservierungAendern(
                reservierungTO.reservierungsnummer()
                ,reservierungTO.reservierungsdatum()
                ,reservierungTO.reservierungsuhrzeit()
                ,reservierungTO.anzahlDerPersonen()
                , reservierungTO.wunsch()
                , reservierungTO.reservierungsstatus()
                , reservierungTO.tischnr()
                ))
            return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.CONFLICT).build(); 
        }
    }
    
    
    @GET
    @Path("/mitarbeiter/freieTische")
    @Produces({MediaType.APPLICATION_JSON}) 
    public TischTOList allFreieTische() {
        
        List <Tisch> liste = tischSuchen.freieTischeSuchen();
        
        TischTOList listeTO;
        if (!liste.isEmpty()) {
            listeTO = new TischTOList( 
                liste.stream()
                .map(TischTO::fromDomain)
                .collect(Collectors.toList())
            );
        }
        else {
            listeTO = new TischTOList(null);
        }
        
        
        return listeTO;
    }
    
    
    @POST
    @Path("/mitarbeiter/bestellungPflegen")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createBestellung(BestellungTO bestellungTO, @Context UriInfo uriInfo ) {

        Bestellung bestellung 
                = bestellungPflegen.bestellungAnlegen(
                        bestellungTO.bestellnummer() 
                        , bestellungTO.bestellposition()
                        , bestellungTO.gesamtbetrag()
                        , bestellungTO.bestellzeitpunkt()
                        , bestellungTO.bestellstatus()
                        );
        
        if (bestellung == null) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        else {
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(bestellung.getBestellnummer()));
            return Response.created(uriBuilder.build()).build();
        }
    }
        
        
    @PUT
    @Path("/mitarbeiter/bestellungPflegen/")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateBestellung(BestellungTO bestellungTO ) {
        
        if (bestellungPflegen.bestellungAendern(
                bestellungTO.bestellnummer() 
                        , bestellungTO.bestellposition()
                        , bestellungTO.gesamtbetrag()
                        , bestellungTO.bestellzeitpunkt()
                        , bestellungTO.bestellstatus()
                ))
            return Response.status(Response.Status.OK).build();
        else {
            return Response.status(Response.Status.CONFLICT).build(); 
        }
    }
    
    
}
