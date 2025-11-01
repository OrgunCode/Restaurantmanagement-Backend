/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class ReservierungSuchen implements IReservierungSuchen {

    @EJB
    ReservierungManager reservierungManager;

    @Override
    public Reservierung reservierungSuchenPerPK(int reservierungsnummer) {
        
        return reservierungManager.reservierungSuchenPerPK(reservierungsnummer);
        
    }
}
