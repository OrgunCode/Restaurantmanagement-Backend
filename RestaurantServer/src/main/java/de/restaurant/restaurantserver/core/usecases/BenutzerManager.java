/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Administrator;
import de.restaurant.restaurantserver.core.entities.Restaurantmanager;
import de.restaurant.restaurantserver.core.entities.Restaurantmitarbeiter;
import de.restaurant.restaurantserver.dataaccess.AdministratorDAO;
import de.restaurant.restaurantserver.dataaccess.RestaurantmanagerDAO;
import de.restaurant.restaurantserver.dataaccess.RestaurantmitarbeiterDAO;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class BenutzerManager {

    @EJB
    AdministratorDAO administratorDAO;
    @EJB
    RestaurantmanagerDAO restaurantmanagerDAO;
    @EJB
    RestaurantmitarbeiterDAO restaurantmitarbeiterDAO;

    public Administrator adminSuchenPerPK(String benutzererkennung) {
        Administrator administrator = administratorDAO.suchen(benutzererkennung);

        return administrator;

    }
    
    public Restaurantmanager managerSuchenPerPK(String benutzererkennung) {
        Restaurantmanager restaurantmanager = restaurantmanagerDAO.suchen(benutzererkennung);

        return restaurantmanager;

    }
    
    public Restaurantmitarbeiter mitarbeiterSuchenPerPK(String benutzererkennung) {
        Restaurantmitarbeiter restaurantmitarbeiter = restaurantmitarbeiterDAO.suchen(benutzererkennung);

        return restaurantmitarbeiter;

    }
    
    public Administrator adminAnlegen(Administrator administrator){
        
        return administratorDAO.anlegen(administrator);
        
    }
    
    public Restaurantmanager managerAnlegen(Restaurantmanager restaurantmanager){
        
        return restaurantmanagerDAO.anlegen(restaurantmanager);
        
    }
    
    public Restaurantmitarbeiter mitarbeiterAnlegen(Restaurantmitarbeiter restaurantmitarbeiter){
        
        return restaurantmitarbeiterDAO.anlegen(restaurantmitarbeiter);
        
    }
    
    public boolean adminAendern(Administrator administrator) {

        return administratorDAO.aendern(administrator);

    }
    
    public boolean managerAendern(Restaurantmanager restaurantmanager) {

        return restaurantmanagerDAO.aendern(restaurantmanager);

    }
    
    public boolean mitarbeiterAendern(Restaurantmitarbeiter restaurantmitarbeiter) {

        return restaurantmitarbeiterDAO.aendern(restaurantmitarbeiter);

    }
    
}
