/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Tisch;
import jakarta.ejb.Local;

/**
 *
 * @author orgun
 */
@Local
public interface ITischPflegen {
    public Tisch tischAnlegen(int nummer, int anzahlPlaetze, String lage, String tischstatus);
    public boolean tischAendern(int nummer, int anzahlPlaetze, String lage, String tischstatus);
}
