/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.core.enumeration.BestellpositionT;
import de.restaurant.restaurantserver.core.enumeration.BestellstatusT;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalTime;

/**
 *
 * @author orgun
 */
@Entity
public class BestellungEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bestellnummer")
    @Column(name ="bestellungsnr")
    private int bestellnummer;
    @Enumerated(EnumType.STRING)
    private BestellpositionT bestellposition;
    private int gesamtbetrag;
    private LocalTime bestellzeitpunkt;
    @Enumerated(EnumType.STRING)
    private BestellstatusT bestellstatus;
    
    public BestellungEntity(){
        
    }

    public BestellungEntity (Bestellung bestellung) {
        this.bestellnummer = bestellung.getBestellnummer();
        this.bestellposition = bestellung.getBestellposition();
        this.gesamtbetrag = bestellung.getGesamtbetrag();
        this.bestellzeitpunkt = bestellung.getBestellzeitpunkt();
        this.bestellstatus = bestellung.getBestellstatus();
    }
    
    public Bestellung toBestellung() {
        return new Bestellung(this.bestellnummer, this.bestellposition, this.gesamtbetrag, this.bestellzeitpunkt, this.bestellstatus);
    }

    public int getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(int bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public BestellpositionT getBestellposition() {
        return bestellposition;
    }

    public void setBestellposition(BestellpositionT bestellposition) {
        this.bestellposition = bestellposition;
    }

    public int getGesamtbetrag() {
        return gesamtbetrag;
    }

    public void setGesamtbetrag(int gesamtbetrag) {
        this.gesamtbetrag = gesamtbetrag;
    }

    public LocalTime getBestellzeitpunkt() {
        return bestellzeitpunkt;
    }

    public void setBestellzeitpunkt(LocalTime bestellzeitpunkt) {
        this.bestellzeitpunkt = bestellzeitpunkt;
    }

    public BestellstatusT getBestellstatus() {
        return bestellstatus;
    }

    public void setBestellstatus(BestellstatusT bestellstatus) {
        this.bestellstatus = bestellstatus;
    }
    
}
