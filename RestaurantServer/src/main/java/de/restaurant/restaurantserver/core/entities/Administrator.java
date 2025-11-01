/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.entities;

/**
 *
 * @author orgun
 */
public class Administrator extends Benutzer {
    
    public Administrator(){
        
    }

    public Administrator(String benutzererkennung, String passwort, String name, String telefonnummer) {
        super(benutzererkennung, passwort, name, telefonnummer);
    }
    
}
