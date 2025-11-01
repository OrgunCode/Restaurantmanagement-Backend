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
public class Restaurantmanager extends Benutzer {
    
    public Restaurantmanager(){
        
    }

    private List<Tisch> tische;

    public Restaurantmanager(String benutzererkennung, String passwort, String name, String telefonnummer, List<Tisch> tische) {
        super(benutzererkennung, passwort, name, telefonnummer);
        this.tische = tische;
    }

    public void addTisch(Tisch tisch) {
        tische.add(tisch);
    }

    public List<Tisch> getTische() {
        return tische;
    }

    public void deleteTisch(Tisch tisch) {
        tische.remove(tisch);
    }
}