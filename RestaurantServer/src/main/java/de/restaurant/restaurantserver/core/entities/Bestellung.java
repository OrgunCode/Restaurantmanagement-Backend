/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.entities;

import de.restaurant.restaurantserver.core.enumeration.BestellpositionT;
import de.restaurant.restaurantserver.core.enumeration.BestellstatusT;
import java.time.LocalTime;

/**
 *
 * @author orgun
 */
public class Bestellung {

    private int bestellnummer;
    private BestellpositionT bestellposition;
    private int gesamtbetrag;
    private LocalTime bestellzeitpunkt;
    private BestellstatusT bestellstatus;
    
    public Bestellung(){
        
    }

    public Bestellung(int bestellnummer, BestellpositionT bestellposition, int gesamtbetrag, LocalTime bestellzeitpunkt, BestellstatusT bestellstatus) {
        this.bestellnummer = bestellnummer;
        this.bestellposition = bestellposition;
        this.gesamtbetrag = gesamtbetrag;
        this.bestellzeitpunkt = bestellzeitpunkt;
        this.bestellstatus = bestellstatus;
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

