/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.enumeration.TischstatusT;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class FreieTischeSuchen implements IFreieTischeSuchen {

    @EJB
    TischManager tischManager;

    @Override
    public List<Tisch> freieTischeSuchen() {
        Tisch suchTisch = new Tisch(0, 0, null, TischstatusT.RESERVIERBAR);

        return tischManager.tischSuchen(suchTisch);
    }
}
