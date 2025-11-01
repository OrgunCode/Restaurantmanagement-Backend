/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Benutzer;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
/**
 *
 * @author orgun
 */
@Stateless
public class BenutzerEinloggen implements IBenutzerEinloggen{

    @EJB BenutzerManager benutzerManager;
    
    @Override
    public Boolean login(String benutzererkennung, String passwort) {
        Benutzer benutzer = benutzerManager.adminSuchenPerPK(benutzererkennung);
        if (benutzer != null) {
           return benutzer.getPasswort().equals(passwort);
        }
        
        benutzer = benutzerManager.managerSuchenPerPK(benutzererkennung);
        if (benutzer != null) {
           return benutzer.getPasswort().equals(passwort);
        }
        
        benutzer = benutzerManager.mitarbeiterSuchenPerPK(benutzererkennung);
        if (benutzer != null) {
           return benutzer.getPasswort().equals(passwort);
        }
        
        return false;
        
    }
    
}
