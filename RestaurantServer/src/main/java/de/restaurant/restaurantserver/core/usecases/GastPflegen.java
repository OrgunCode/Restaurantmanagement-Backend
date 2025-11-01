/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.datatype.AdresseT;
import de.restaurant.restaurantserver.core.entities.Bestellung;
import de.restaurant.restaurantserver.core.entities.Gast;
import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.enumeration.VorliebenT;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class GastPflegen implements IGastPflegen {

    @EJB
    GastManager gastManager;
    @EJB
    ReservierungManager reservierungManager;
    @EJB
    BestellungManager bestellungManager;

    @Override
    public Gast gastAnlegen(int kundennummer, String name, String strasse, String hausnummer, String plz, String ort, String land, String telefonnummer, String eMailAdresse, LocalDate geburtsdatum, String vorlieben, List<Integer> reservierungsnr, List<Integer> bestellungsnr) {

        List<Reservierung> gefundeneReservierungen = new ArrayList<>();
        List<Bestellung> gefundeneBestellungen = new ArrayList<>();

        for (Integer rNr : reservierungsnr) {
            Reservierung reservierung = reservierungManager.reservierungSuchenPerPK(rNr);
            if (reservierung == null) {
                return null;
            }
            gefundeneReservierungen.add(reservierung);
        }

        for (Integer bNr : bestellungsnr) {
            Bestellung bestellung = bestellungManager.bestellungSuchenPerPK(bNr);
            if (bestellung == null) {
                return null;
            }
            gefundeneBestellungen.add(bestellung);
        }

        Gast gast = new Gast();

        gast.setKundennummer(kundennummer);
        gast.setName(name);
        gast.setAdresse(new AdresseT(strasse, hausnummer, plz, ort, land));
        gast.setTelefonnummer(telefonnummer);
        gast.setEMailAdresse(eMailAdresse);
        gast.setGeburtsdatum(geburtsdatum);
        gast.setVorlieben(VorliebenT.valueOf(vorlieben.trim().toUpperCase()));
        for (Reservierung r : gefundeneReservierungen) {
            gast.addReservierung(r);
        }
        for (Bestellung b : gefundeneBestellungen) {
            gast.addBestellung(b);
        }

        return gastManager.gastAnlegen(gast);
    }

    @Override
    public boolean gastAendern(int kundennummer, String name, String strasse, String hausnummer, String plz, String ort, String land, String telefonnummer, String eMailAdresse, LocalDate geburtsdatum, String vorlieben, List<Integer> reservierungsnr, List<Integer> bestellungsnr) {
        List<Reservierung> gefundeneReservierungen = new ArrayList<>();
        List<Bestellung> gefundeneBestellungen = new ArrayList<>();
        Gast gast = gastManager.gastSuchenPerPK(kundennummer);
        if (gast == null) {
            return false;
        }

        for (Integer rNr : reservierungsnr) {
            Reservierung reservierung = reservierungManager.reservierungSuchenPerPK(rNr);
            if (reservierung == null) {
                return false;
            }
            gefundeneReservierungen.add(reservierung);
        }

        for (Integer bNr : bestellungsnr) {
            Bestellung bestellung = bestellungManager.bestellungSuchenPerPK(bNr);
            if (bestellung == null) {
                return false;
            }
            gefundeneBestellungen.add(bestellung);
        }

        gast.setName(name);
        gast.setAdresse(new AdresseT(strasse, hausnummer, plz, ort, land));
        gast.setTelefonnummer(telefonnummer);
        gast.setEMailAdresse(eMailAdresse);
        gast.setGeburtsdatum(geburtsdatum);
        gast.setVorlieben(VorliebenT.valueOf(vorlieben.trim().toUpperCase()));
        for (Reservierung r : gefundeneReservierungen) {
            gast.addReservierung(r);
        }
        for (Bestellung b : gefundeneBestellungen) {
            gast.addBestellung(b);
        }

        return gastManager.gastAendern(gast);
    }

}
