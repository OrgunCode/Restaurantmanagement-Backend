/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author orgun
 */
public record GastTO(
        int kundennummer,
        String name,
        String strasse,
        String hausnummer,
        String plz,
        String ort,
        String land,
        String telefonnummer,
        String eMailAdresse,
        LocalDate geburtsdatum,
        String vorlieben,
        List<Integer> reservierungsnr,
        List<Integer> bestellungsnr
        ) {

}
