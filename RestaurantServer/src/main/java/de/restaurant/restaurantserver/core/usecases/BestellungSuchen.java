/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class BestellungSuchen implements IBestellungSuchen {

    @EJB
    BestellungManager bestellungManager;

    @Override
    public Bestellung bestellungSuchenPerPK(int bestellnummer) {

        return bestellungManager.bestellungSuchenPerPK(bestellnummer);

    }
}
