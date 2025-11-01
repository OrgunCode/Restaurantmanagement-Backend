/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Benutzer;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author orgun
 */
@Entity
public class BenutzerEntity {
    
    @Id
    private String benutzererkennung;
    @NotNull
    private String passwort;
    private String name;
    private String telefonnummer;
    
    public BenutzerEntity(){
        
    }
    
    public BenutzerEntity (Benutzer benutzer) {
        this.benutzererkennung = benutzer.getBenutzererkennung();
        this.passwort = benutzer.getPasswort();
        this.name = benutzer.getName();
        this.telefonnummer = benutzer.getTelefonnummer();
    }
    
    public Benutzer toBenutzer() {
        return new Benutzer(this.benutzererkennung, this.passwort, this.name, this.telefonnummer);
    }

    public String getBenutzererkennung() {
        return benutzererkennung;
    }

    public void setBenutzererkennung(String benutzererkennung) {
        this.benutzererkennung = benutzererkennung;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
      
    
}
