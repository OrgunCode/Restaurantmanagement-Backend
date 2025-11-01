/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Benutzer;
import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.core.entities.Gast;
import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Restaurantmitarbeiter;
import de.restaurant.restaurantserver.core.entities.Tisch;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orgun
 */
@Entity
public class RestaurantmitarbeiterEntity extends BenutzerEntity {

    @ManyToMany
    @JoinColumn(name = "GASTNR", referencedColumnName = "GASTNR")
    private List<GastEntity> gastentity;
    
    public RestaurantmitarbeiterEntity(){
        
    }

    public RestaurantmitarbeiterEntity(Restaurantmitarbeiter restaurantmitarbeiter) {
        super(new Benutzer(restaurantmitarbeiter.getBenutzererkennung(), restaurantmitarbeiter.getPasswort(), restaurantmitarbeiter.getName(), restaurantmitarbeiter.getTelefonnummer()));
        for (Gast g : restaurantmitarbeiter.getGaeste()) {
            this.gastentity.add(new GastEntity(g));
        }
    }

    public Restaurantmitarbeiter toRestaurantmitarbeiter() {
        List<Gast> gastListe = new ArrayList<>();

        for (GastEntity g : gastentity) {
            List<Reservierung> reservierungListe = new ArrayList<>();
            List<Bestellung> bestellungListe = new ArrayList<>();
            for (ReservierungEntity r : g.getReservierungentity()) {
                List<Tisch> tischListe = new ArrayList<>();
                for (TischEntity t : r.getTischentity()) {
                    tischListe.add(new Tisch(t.getNummer(), t.getAnzahlPlaetze(), t.getLage(), t.getTischstatus()));
                }
                reservierungListe.add(new Reservierung(r.getReservierungsnummer(), r.getReservierungsdatum(), r.getReservierungsuhrzeit(), r.getAnzahlDerPersonen(), r.getWunsch(), r.getReservierungsstatus(), tischListe));
            }

            for (BestellungEntity b : g.getBestellungentity()) {
                bestellungListe.add(new Bestellung(b.getBestellnummer(), b.getBestellposition(), b.getGesamtbetrag(), b.getBestellzeitpunkt(), b.getBestellstatus()));
            }
            gastListe.add(new Gast(g.getKundennummer(), g.getName(), g.getAdresse(), g.getTelefonnummer(), g.getEMailAdresse(), g.getGeburtsdatum(), g.getVorlieben(), reservierungListe, bestellungListe));
        }

        return new Restaurantmitarbeiter(this.getBenutzererkennung(), this.getPasswort(), this.getName(), this.getTelefonnummer(), gastListe);
    }

    public List<GastEntity> getGastentity() {
        return gastentity;
    }

    public void setGastentity(List<GastEntity> gastentity) {
        this.gastentity = gastentity;
    }

}
