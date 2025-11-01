/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import jakarta.ejb.Local;
import java.time.LocalTime;

/**
 *
 * @author orgun
 */
@Local
public interface IBestellungPflegen {
    public Bestellung bestellungAnlegen(int bestellnummer, String bestellposition, int gesamtbetrag, LocalTime bestellzeitpunkt, String bestellstatus);
    public boolean bestellungAendern(int bestellnummer, String bestellposition, int gesamtbetrag, LocalTime bestellzeitpunkt, String bestellstatus);
}
