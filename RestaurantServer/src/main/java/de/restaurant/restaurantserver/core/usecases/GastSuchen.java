/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Gast;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class GastSuchen implements IGastSuchen {

    @EJB
    GastManager gastManager;

    @Override
    public Gast gastSuchenPerPK(int kundennummer) {
        return gastManager.gastSuchenPerPK(kundennummer);
    }
}
