/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import java.time.LocalTime;

/**
 *
 * @author orgun
 */
public record BestellungTO(
        int bestellnummer,
        String bestellposition,
        int gesamtbetrag,
        LocalTime bestellzeitpunkt,
        String bestellstatus
        ) {

}
