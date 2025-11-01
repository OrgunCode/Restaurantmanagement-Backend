/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.dataaccess.ReservierungDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class ReservierungManager {

    @EJB
    ReservierungDAO reservierungDAO;

    public Reservierung reservierungSuchenPerPK(int reservierungsnummer) {

        return reservierungDAO.suchen(reservierungsnummer);

    }

    public Reservierung reservierungAnlegen(Reservierung reservierung) {
        return reservierungDAO.anlegen(reservierung);

    }

    public boolean reservierungAendern(Reservierung reservierung) {

        return reservierungDAO.aendern(reservierung);

    }
    
    public List<Reservierung> reservierungSuchen(Reservierung suchReservierung) {
            
        return reservierungDAO.suchen(suchReservierung);
           
    }

}
