/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.dataaccess.TischDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class TischManager {

    @EJB
    TischDAO tischDAO;

    public Tisch tischSuchenPerPK(int nummer) {

        return tischDAO.suchen(nummer);

    }

    public Tisch tischAnlegen(Tisch tisch) {
        return tischDAO.anlegen(tisch);

    }
    
    public boolean tischAendern (Tisch tisch) {
            
        return tischDAO.aendern(tisch);
            
    }
    
    public List<Tisch> tischSuchen(Tisch suchTisch) {
            
        return tischDAO.suchen(suchTisch);
           
    }
    
}
