/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Administrator;
import de.restaurant.restaurantserver.core.entities.Restaurantmanager;
import de.restaurant.restaurantserver.core.entities.Restaurantmitarbeiter;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author orgun
 */
@Local
public interface IBenutzerPflegen {
    public Administrator adminAnlegen(String benutzererkennung, String passwort, String name, String telefonnummer);
    public Restaurantmanager managerAnlegen(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> tischn);
    public Restaurantmitarbeiter mitarbeiterAnlegen(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> gastnr);
    public boolean adminAendern(String benutzererkennung, String passwort, String name, String telefonnummer);
    public boolean managerAendern(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> tischnr);
    public boolean mitarbeiterAendern(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> gastnr);
}
