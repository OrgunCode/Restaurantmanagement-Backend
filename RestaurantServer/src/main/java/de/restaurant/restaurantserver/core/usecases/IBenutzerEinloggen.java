/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import jakarta.ejb.Local;

/**
 *
 * @author orgun
 */
@Local
public interface IBenutzerEinloggen {
    
    public Boolean login(String kennung, String secret);
    
}
