/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import de.restaurant.restaurantserver.core.entities.Tisch;

/**
 *
 * @author orgun
 */
public record TischTO(
        int nummer,
        int anzahlPlaetze,
        String lage,
        String tischstatus
        ) {

    public static TischTO fromDomain(Tisch tisch) {
        if (tisch == null) {
            return null;
        }
        
        return new TischTO(
                tisch.getNummer(),
                tisch.getAnzahlPlaetze(),
                (tisch.getLage() != null) ? tisch.getLage().name() : null,
                (tisch.getTischstatus() != null) ? tisch.getTischstatus().name() : null
        );
    }
}
