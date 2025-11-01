/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.core.enumeration.BestellpositionT;
import de.restaurant.restaurantserver.core.enumeration.BestellstatusT;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.time.LocalTime;

/**
 *
 * @author orgun
 */
@Stateless
public class BestellungPflegen implements IBestellungPflegen {

    @EJB
    BestellungManager bestellungManager;

    @Override
    public Bestellung bestellungAnlegen(int bestellnummer, String bestellposition, int gesamtbetrag, LocalTime bestellzeitpunkt, String bestellstatus) {

        Bestellung bestellung = new Bestellung();

        bestellung.setBestellnummer(bestellnummer);
        bestellung.setBestellposition(BestellpositionT.valueOf(bestellposition.trim().toUpperCase()));
        bestellung.setGesamtbetrag(gesamtbetrag);
        bestellung.setBestellzeitpunkt(bestellzeitpunkt);
        bestellung.setBestellstatus(BestellstatusT.valueOf(bestellstatus.trim().toUpperCase()));

        return bestellungManager.bestellungAnlegen(bestellung);
    }
    
    @Override
    public boolean bestellungAendern(int bestellnummer, String bestellposition, int gesamtbetrag, LocalTime bestellzeitpunkt, String bestellstatus){
        Bestellung bestellung = bestellungManager.bestellungSuchenPerPK(bestellnummer);
        if (bestellung == null) {
            return false;
        }
        
        bestellung.setBestellposition(BestellpositionT.valueOf(bestellposition.trim().toUpperCase()));
        bestellung.setGesamtbetrag(gesamtbetrag);
        bestellung.setBestellzeitpunkt(bestellzeitpunkt);
        bestellung.setBestellstatus(BestellstatusT.valueOf(bestellstatus.trim().toUpperCase()));
        
        return bestellungManager.bestellungAendern(bestellung);
    }
    
}
