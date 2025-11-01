/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.entities;

/**
 *
 * @author orgun
 */
import de.restaurant.restaurantserver.core.enumeration.LageT;
import de.restaurant.restaurantserver.core.enumeration.ReservierungsstatusT;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class Reservierung {

    private int reservierungsnummer;
    private LocalDate reservierungsdatum;
    private LocalTime reservierungsuhrzeit;
    private int anzahlDerPersonen;
    private LageT wunsch;
    private ReservierungsstatusT reservierungsstatus;
    private List<Tisch> tische;

    public Reservierung(){
        
    }

    public Reservierung(int reservierungsnummer, LocalDate reservierungsdatum, LocalTime reservierungsuhrzeit, int anzahlDerPersonen, LageT wunsch, ReservierungsstatusT reservierungsstatus, List<Tisch> tische) {
        this.reservierungsnummer = reservierungsnummer;
        this.reservierungsdatum = reservierungsdatum;
        this.reservierungsuhrzeit = reservierungsuhrzeit;
        this.anzahlDerPersonen = anzahlDerPersonen;
        this.wunsch = wunsch;
        this.reservierungsstatus = reservierungsstatus;
        this.tische = tische;
    }

    public int getReservierungsnummer() {
        return reservierungsnummer;
    }

    public void setReservierungsnummer(int reservierungsnummer) {
        this.reservierungsnummer = reservierungsnummer;
    }

    public LocalDate getReservierungsdatum() {
        return reservierungsdatum;
    }

    public void setReservierungsdatum(LocalDate reservierungsdatum) {
        this.reservierungsdatum = reservierungsdatum;
    }

    public LocalTime getReservierungsuhrzeit() {
        return reservierungsuhrzeit;
    }

    public void setReservierungsuhrzeit(LocalTime reservierungsuhrzeit) {
        this.reservierungsuhrzeit = reservierungsuhrzeit;
    }

    public int getAnzahlDerPersonen() {
        return anzahlDerPersonen;
    }

    public void setAnzahlDerPersonen(int anzahlDerPersonen) {
        this.anzahlDerPersonen = anzahlDerPersonen;
    }

    public LageT getWunsch() {
        return wunsch;
    }

    public void setWunsch(LageT wunsch) {
        this.wunsch = wunsch;
    }

    public ReservierungsstatusT getReservierungsstatus() {
        return reservierungsstatus;
    }

    public void setReservierungsstatus(ReservierungsstatusT reservierungsstatus) {
        this.reservierungsstatus = reservierungsstatus;
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

