/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Tisch;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author orgun
 */
public record ReservierungTO(
        int reservierungsnummer,
        LocalDate reservierungsdatum,
        LocalTime reservierungsuhrzeit,
        int anzahlDerPersonen,
        String wunsch,
        String reservierungsstatus,
        List<Integer> tischnr
        ) {

    public static ReservierungTO fromDomain(Reservierung reservierung) {
        if (reservierung == null) {
            return null;
        }
        return new ReservierungTO(
                reservierung.getReservierungsnummer(),
                reservierung.getReservierungsdatum(),
                reservierung.getReservierungsuhrzeit(),
                reservierung.getAnzahlDerPersonen(),
                (reservierung.getWunsch() != null) ? reservierung.getWunsch().name() : null,
                (reservierung.getReservierungsstatus() != null) ? reservierung.getReservierungsstatus().name() : null,
                (reservierung.getTische() != null)
                ? reservierung.getTische().stream()
                        .map(Tisch::getNummer)
                        .collect(java.util.stream.Collectors.toList())
                : java.util.Collections.emptyList()
        );
    }
}
