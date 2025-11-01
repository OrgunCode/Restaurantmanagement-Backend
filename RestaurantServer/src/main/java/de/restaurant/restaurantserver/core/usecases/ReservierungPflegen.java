/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.enumeration.LageT;
import de.restaurant.restaurantserver.core.enumeration.ReservierungsstatusT;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class ReservierungPflegen implements IReservierungPflegen {

    @EJB
    ReservierungManager reservierungManager;
    @EJB
    TischManager tischManager;

    @Override
    public Reservierung reservierungAnlegen(int reservierungsnummer, LocalDate reservierungsdatum, LocalTime reservierungsuhrzeit, int anzahlDerPersonen, String wunsch, String reservierungsstatus, List<Integer> tischnr) {

        List<Tisch> gefundeneTische = new ArrayList<>();

        for (Integer tischId : tischnr) {
            Tisch tisch = tischManager.tischSuchenPerPK(tischId);
            if (tisch == null) {
                return null;
            }
            gefundeneTische.add(tisch);
        }

        Reservierung reservierung = new Reservierung();

        reservierung.setReservierungsnummer(reservierungsnummer);
        reservierung.setReservierungsdatum(reservierungsdatum);
        reservierung.setReservierungsuhrzeit(reservierungsuhrzeit);
        reservierung.setAnzahlDerPersonen(anzahlDerPersonen);
        reservierung.setWunsch(LageT.valueOf(wunsch.trim().toUpperCase()));
        reservierung.setReservierungsstatus(ReservierungsstatusT.valueOf(reservierungsstatus.trim().toUpperCase()));
        for (Tisch t : gefundeneTische) {
            reservierung.addTisch(t);
        }

        return reservierungManager.reservierungAnlegen(reservierung);
    }

    @Override
    public boolean reservierungAendern(int reservierungsnummer, LocalDate reservierungsdatum, LocalTime reservierungsuhrzeit, int anzahlDerPersonen, String wunsch, String reservierungsstatus, List<Integer> tischnr) {
        List<Tisch> gefundeneTische = new ArrayList<>();
        Reservierung reservierung = reservierungManager.reservierungSuchenPerPK(reservierungsnummer);
        if (reservierung == null) {
            return false;
        }

        for (Integer tischId : tischnr) {
            Tisch tisch = tischManager.tischSuchenPerPK(tischId);
            if (tisch == null) {
                return false;
            }
            gefundeneTische.add(tisch);
        }

        reservierung.setReservierungsdatum(reservierungsdatum);
        reservierung.setReservierungsuhrzeit(reservierungsuhrzeit);
        reservierung.setAnzahlDerPersonen(anzahlDerPersonen);
        reservierung.setWunsch(LageT.valueOf(wunsch.trim().toUpperCase()));
        reservierung.setReservierungsstatus(ReservierungsstatusT.valueOf(reservierungsstatus.trim().toUpperCase()));
        for (Tisch t : gefundeneTische) {
            reservierung.addTisch(t);
        }

        return reservierungManager.reservierungAendern(reservierung);
    }

}
