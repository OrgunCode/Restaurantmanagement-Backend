/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.entities;

/**
 *
 * @author orgun
 */
public class Benutzer {

    private String benutzererkennung;
    private String passwort;
    private String name;
    private String telefonnummer;
    
    public Benutzer(){
        
    }

    public Benutzer(String benutzererkennung, String passwort, String name, String telefonnummer) {
        this.benutzererkennung = benutzererkennung;
        this.passwort = passwort;
        this.name = name;
        this.telefonnummer = telefonnummer;
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
