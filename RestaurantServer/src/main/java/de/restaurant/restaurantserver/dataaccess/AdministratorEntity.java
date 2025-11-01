/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Administrator;
import de.restaurant.restaurantserver.core.entities.Benutzer;
import jakarta.persistence.Entity;

/**
 *
 * @author orgun
 */
@Entity
public class AdministratorEntity extends BenutzerEntity{
    
    public AdministratorEntity(){
        
    }
    
    public AdministratorEntity(Benutzer benutzer) {
        super(benutzer);
    }
    
    public Administrator toAdministrator() {
        return new Administrator(this.getBenutzererkennung(), this.getPasswort(), this.getName(), this.getTelefonnummer());
    }
    
}
