/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.entities;

import java.util.List;

/**
 *
 * @author orgun
 */
public class Restaurantmitarbeiter extends Benutzer {

    private List<Gast> gaeste;
    
    public Restaurantmitarbeiter(){
        
    }

    public Restaurantmitarbeiter(String benutzererkennung, String passwort, String name, String telefonnummer, List<Gast> gaeste) {
        super(benutzererkennung, passwort, name, telefonnummer);
        this.gaeste = gaeste;
    }

    public void addGast(Gast gast) {
        gaeste.add(gast);
    }

    public List<Gast> getGaeste() {
        return gaeste;
    }

    public void deleteGast(Gast gast) {
        gaeste.remove(gast);
    }
    
}
