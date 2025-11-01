/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import jakarta.ejb.Local;

/**
 *
 * @author orgun
 */
@Local
public interface IBestellungSuchen {
    public Bestellung bestellungSuchenPerPK(int bestellnummer);
}
