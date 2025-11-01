/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Gast;
import de.restaurant.restaurantserver.dataaccess.GastDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class GastManager {

    @EJB
    GastDAO gastDAO;

    public Gast gastSuchenPerPK(int kundennummer) {

        return gastDAO.suchen(kundennummer);

    }

    public Gast gastAnlegen(Gast gast) {
        return gastDAO.anlegen(gast);

    }

    public boolean gastAendern(Gast gast) {

        return gastDAO.aendern(gast);

    }

}
