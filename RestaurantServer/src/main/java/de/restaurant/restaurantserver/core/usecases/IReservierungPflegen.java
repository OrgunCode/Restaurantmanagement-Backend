/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import jakarta.ejb.Local;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author orgun
 */
@Local
public interface IReservierungPflegen {
    public Reservierung reservierungAnlegen(int reservierungsnummer, LocalDate reservierungsdatum, LocalTime reservierungsuhrzeit, int anzahlDerPersonen, String wunsch, String reservierungsstatus, List<Integer> tischnr);
    public boolean reservierungAendern(int reservierungsnummer, LocalDate reservierungsdatum, LocalTime reservierungsuhrzeit, int anzahlDerPersonen, String wunsch, String reservierungsstatus, List<Integer> tischnr);
}
