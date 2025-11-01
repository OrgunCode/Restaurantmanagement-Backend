/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Tisch;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author orgun
 */
@Local
public interface IFreieTischeSuchen {

    public List<Tisch> freieTischeSuchen();
}
