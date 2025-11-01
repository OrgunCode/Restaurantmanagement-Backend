/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Administrator;
import de.restaurant.restaurantserver.core.entities.Restaurantmanager;
import de.restaurant.restaurantserver.core.entities.Restaurantmitarbeiter;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class BenutzerSuchen implements IBenutzerSuchen{
    
    @EJB BenutzerManager benutzerManager;
    
    @Override
    public Administrator adminSuchenPerPK(String benutzererkennung) {
        
        return benutzerManager.adminSuchenPerPK(benutzererkennung);
        
    }
    
    @Override
    public Restaurantmanager managerSuchenPerPK(String benutzererkennung) {
        
        return benutzerManager.managerSuchenPerPK(benutzererkennung);
        
    }
    
    @Override
    public Restaurantmitarbeiter mitarbeiterSuchenPerPK(String benutzererkennung) {
        
        return benutzerManager.mitarbeiterSuchenPerPK(benutzererkennung);
        
    }
    
}
