/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.dataaccess.BestellungDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class BestellungManager {

    @EJB
    BestellungDAO bestellungDAO;

    public Bestellung bestellungSuchenPerPK(int bestellnummer) {

        return bestellungDAO.suchen(bestellnummer);

    }

    public Bestellung bestellungAnlegen(Bestellung bestellung) {
        return bestellungDAO.anlegen(bestellung);

    }
    
    public boolean bestellungAendern (Bestellung bestellung) {
            
        return bestellungDAO.aendern(bestellung);
            
    }
    
    public List<Bestellung> bestellungSuchen(Bestellung suchBestellung) {
            
        return bestellungDAO.suchen(suchBestellung);
           
    }
    
}
