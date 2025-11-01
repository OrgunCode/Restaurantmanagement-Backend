/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Gast;
import jakarta.ejb.Local;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author orgun
 */
@Local
public interface IGastPflegen {
    public Gast gastAnlegen(int kundennummer, String name, String strasse, String hausnummer, String plz, String ort, String land, String telefonnummer, String eMailAdresse, LocalDate geburtsdatum, String vorlieben, List<Integer> reservierungsnr, List<Integer> bestellungsnr);
    public boolean gastAendern(int kundennummer, String name, String strasse, String hausnummer, String plz, String ort, String land, String telefonnummer, String eMailAdresse, LocalDate geburtsdatum, String vorlieben, List<Integer> reservierungsnr, List<Integer> bestellungsnr);
}
