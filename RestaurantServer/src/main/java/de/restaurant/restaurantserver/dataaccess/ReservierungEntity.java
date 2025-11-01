/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.enumeration.LageT;
import de.restaurant.restaurantserver.core.enumeration.ReservierungsstatusT;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orgun
 */
@Entity
public class ReservierungEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservierungsnummer")
    @Column(name ="reservierungsnr")
    private int reservierungsnummer;
    @ManyToMany
    @JoinColumn(name="TISCHNR", referencedColumnName = "TISCHNR")
    private List<TischEntity> tischentity;
    private LocalDate reservierungsdatum;
    private LocalTime reservierungsuhrzeit;
    private int anzahlDerPersonen;
    @Enumerated(EnumType.STRING)
    private LageT wunsch;
    @Enumerated(EnumType.STRING)
    private ReservierungsstatusT reservierungsstatus;
    
    public ReservierungEntity(){
        
    }
    
    public ReservierungEntity(Reservierung reservierung) {
        this.reservierungsnummer = reservierung.getReservierungsnummer();
        this.reservierungsdatum = reservierung.getReservierungsdatum();
        this.reservierungsuhrzeit = reservierung.getReservierungsuhrzeit();
        this.anzahlDerPersonen = reservierung.getAnzahlDerPersonen();
        this.wunsch = reservierung.getWunsch();
        this.reservierungsstatus = reservierung.getReservierungsstatus();
        for (Tisch t : reservierung.getTische()){
            this.tischentity.add(new TischEntity(t));
        }
    }
    
    public Reservierung toReservierung() {
        List<Tisch> tischListe = new ArrayList<>();
        
        for (TischEntity t : tischentity){
            tischListe.add(new Tisch(t.getNummer(), t.getAnzahlPlaetze(), t.getLage(), t.getTischstatus()));
        }
        return new Reservierung(this.reservierungsnummer , this.reservierungsdatum, this.reservierungsuhrzeit, this.anzahlDerPersonen, this.wunsch, this.reservierungsstatus, tischListe);
    }

    public int getReservierungsnummer() {
        return reservierungsnummer;
    }

    public void setReservierungsnummer(int reservierungsnummer) {
        this.reservierungsnummer = reservierungsnummer;
    }

    public List<TischEntity> getTischentity() {
        return tischentity;
    }

    public void setTischentity(List<TischEntity> tischentity) {
        this.tischentity = tischentity;
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
    
    
}
