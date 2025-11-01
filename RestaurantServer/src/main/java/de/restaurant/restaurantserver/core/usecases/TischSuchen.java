/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Tisch;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class TischSuchen implements ITischSuchen {

    @EJB
    TischManager tischManager;

    @Override
    public Tisch tischSuchenPerPK(int nummer) {

        return tischManager.tischSuchenPerPK(nummer);

    }

}
