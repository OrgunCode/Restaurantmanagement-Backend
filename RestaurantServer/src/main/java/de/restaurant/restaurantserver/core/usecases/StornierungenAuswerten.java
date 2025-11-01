/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.enumeration.BestellstatusT;
import de.restaurant.restaurantserver.core.enumeration.ReservierungsstatusT;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class StornierungenAuswerten implements IStornierungenAuswerten {

    @EJB
    ReservierungManager reservierungManager;
    @EJB
    BestellungManager bestellungManager;

    @Override
    public List<Reservierung> reservierungStornierungenAuswerten() {
        Reservierung suchReservierung = new Reservierung(0, null, null, 0, null, ReservierungsstatusT.STORNIERT, null);

        return reservierungManager.reservierungSuchen(suchReservierung);
    }

    @Override
    public List<Bestellung> bestellungStornierungenAuswerten() {
        Bestellung suchBestellung = new Bestellung(0, null, 0, null, BestellstatusT.STORNIERT);

        return bestellungManager.bestellungSuchen(suchBestellung);
    }
}
