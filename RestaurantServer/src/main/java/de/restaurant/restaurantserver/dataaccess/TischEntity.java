/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.enumeration.LageT;
import de.restaurant.restaurantserver.core.enumeration.TischstatusT;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author orgun
 */
@Entity
public class TischEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nummer")
    @Column(name ="tischnr")
    private int nummer;
    private int anzahlPlaetze;
    @Enumerated(EnumType.STRING)
    private LageT lage;
    @Enumerated(EnumType.STRING)
    private TischstatusT tischstatus;
    
    public TischEntity(){
        
    }
    
    public TischEntity (Tisch tisch) {
            this.nummer = tisch.getNummer();
            this.anzahlPlaetze = tisch.getAnzahlPlaetze();
            this.lage = tisch.getLage();
            this.tischstatus = tisch.getTischstatus();
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
    
    public Tisch toTisch() {
        return new Tisch(this.nummer, this.anzahlPlaetze, this.lage, this.tischstatus);
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
