/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.datatype.AdresseT;
import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.core.entities.Gast;
import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.enumeration.VorliebenT;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orgun
 */
@Entity
public class GastEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kundennummer")
    @Column(name ="gastnr")
    private int kundennummer;
    @OneToMany
    @JoinColumn(name="RESERVIERUNGSNR", referencedColumnName = "RESERVIERUNGSNR")
    private List<ReservierungEntity> reservierungentity;
    @OneToMany
    @JoinColumn(name="BESTELLUNGSNR", referencedColumnName = "BESTELLUNGSNR")
    private List<BestellungEntity> bestellungentity;
    private String name;
    @Embedded
    private AdresseT adresse;
    private String telefonnummer;
    private String eMailAdresse;
    private LocalDate geburtsdatum;
    @Enumerated(EnumType.STRING)
    private VorliebenT vorlieben;
    
    public GastEntity(){
        
    }

    public GastEntity(Gast gast) {
        this.kundennummer = gast.getKundennummer();
        this.name = gast.getName();
        this.adresse = gast.getAdresse();
        this.telefonnummer = gast.getTelefonnummer();
        this.eMailAdresse = gast.getEMailAdresse();
        this.geburtsdatum = gast.getGeburtsdatum();
        this.vorlieben = gast.getVorlieben();
        for (Reservierung r : gast.getReservierungen()){
            this.reservierungentity.add(new ReservierungEntity(r));
        }
        for (Bestellung b : gast.getBestellungen()){
            this.bestellungentity.add(new BestellungEntity(b));
        }
    }
    
    public Gast toGast() {
        List<Reservierung> reservierungListe = new ArrayList<>();
        List<Bestellung> bestellungListe = new ArrayList<>();
        
        for (ReservierungEntity r : reservierungentity){
            List<Tisch> tischListe = new ArrayList<>();
            for (TischEntity t : r.getTischentity()){
                tischListe.add(new Tisch(t.getNummer(), t.getAnzahlPlaetze(), t.getLage(), t.getTischstatus()));
            }
            reservierungListe.add(new Reservierung(r.getReservierungsnummer(), r.getReservierungsdatum(), r.getReservierungsuhrzeit(), r.getAnzahlDerPersonen(), r.getWunsch(), r.getReservierungsstatus(), tischListe));
        }
        
        for (BestellungEntity b : bestellungentity){
            bestellungListe.add(new Bestellung(b.getBestellnummer(), b.getBestellposition(), b.getGesamtbetrag(), b.getBestellzeitpunkt(), b.getBestellstatus()));
        }
        
        return new Gast(this.kundennummer, this.name, this.adresse, this.telefonnummer, this.eMailAdresse, this.geburtsdatum, this.vorlieben, reservierungListe, bestellungListe);
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
    }

    public List<ReservierungEntity> getReservierungentity() {
        return reservierungentity;
    }

    public void setReservierungentity(List<ReservierungEntity> reservierungentity) {
        this.reservierungentity = reservierungentity;
    }

    public List<BestellungEntity> getBestellungentity() {
        return bestellungentity;
    }

    public void setBestellungentity(List<BestellungEntity> bestellungentity) {
        this.bestellungentity = bestellungentity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdresseT getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseT adresse) {
        this.adresse = adresse;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEMailAdresse() {
        return eMailAdresse;
    }

    public void setEMailAdresse(String eMailAdresse) {
        this.eMailAdresse = eMailAdresse;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(LocalDate geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public VorliebenT getVorlieben() {
        return vorlieben;
    }

    public void setVorlieben(VorliebenT vorlieben) {
        this.vorlieben = vorlieben;
    }
    
}
