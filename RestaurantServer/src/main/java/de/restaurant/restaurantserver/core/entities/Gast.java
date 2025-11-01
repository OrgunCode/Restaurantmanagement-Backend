/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.entities;

/**
 *
 * @author orgun
 */
import de.restaurant.restaurantserver.core.datatype.AdresseT;
import de.restaurant.restaurantserver.core.enumeration.VorliebenT;
import java.time.LocalDate;
import java.util.List;

public class Gast {

    private int kundennummer;
    private String name;
    private AdresseT adresse;
    private String telefonnummer;
    private String eMailAdresse;
    private LocalDate geburtsdatum;
    private VorliebenT vorlieben;
    private List<Reservierung> reservierungen;
    private List<Bestellung> bestellungen;
    
    public Gast(){
        
    }

    public Gast(int kundennummer, String name, AdresseT adresse, String telefonnummer, String eMailAdresse, LocalDate geburtsdatum, VorliebenT vorlieben, List<Reservierung> reservierungen, List<Bestellung> bestellungen) {
        this.kundennummer = kundennummer;
        this.name = name;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.eMailAdresse = eMailAdresse;
        this.geburtsdatum = geburtsdatum;
        this.vorlieben = vorlieben;
        this.reservierungen = reservierungen;
        this.bestellungen = bestellungen;
    }

    public int getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(int kundennummer) {
        this.kundennummer = kundennummer;
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

    public void addReservierung(Reservierung reservierung) {
        reservierungen.add(reservierung);
    }

    public List<Reservierung> getReservierungen() {
        return reservierungen;
    }
    
    public void deleteReservierung(Reservierung reservierung) {
        reservierungen.remove(reservierung);
    }
    
    public void addBestellung(Bestellung bestellung) {
        bestellungen.add(bestellung);
    }

    public List<Bestellung> getBestellungen() {
        return bestellungen;
    }
    
    public void deleteBestellung(Bestellung bestellung) {
        bestellungen.remove(bestellung);
    }
}

