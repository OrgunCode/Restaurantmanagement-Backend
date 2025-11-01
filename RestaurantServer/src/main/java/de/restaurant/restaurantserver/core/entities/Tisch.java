/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.entities;

import de.restaurant.restaurantserver.core.enumeration.LageT;
import de.restaurant.restaurantserver.core.enumeration.TischstatusT;

/**
 *
 * @author orgun
 */
public class Tisch {

    private int nummer;
    private int anzahlPlaetze;
    private LageT lage;
    private TischstatusT tischstatus;
    
    public Tisch(){
        
    }

    public Tisch(int nummer, int anzahlPlaetze, LageT lage, TischstatusT tischstatus) {
        this.nummer = nummer;
        this.anzahlPlaetze = anzahlPlaetze;
        this.lage = lage;
        this.tischstatus = tischstatus;
    }

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public int getAnzahlPlaetze() {
        return anzahlPlaetze;
    }

    public void setAnzahlPlaetze(int anzahlPlaetze) {
        this.anzahlPlaetze = anzahlPlaetze;
    }

    public LageT getLage() {
        return lage;
    }

    public void setLage(LageT lage) {
        this.lage = lage;
    }

    public TischstatusT getTischstatus() {
        return tischstatus;
    }

    public void setTischstatus(TischstatusT tischstatus) {
        this.tischstatus = tischstatus;
    }

}

