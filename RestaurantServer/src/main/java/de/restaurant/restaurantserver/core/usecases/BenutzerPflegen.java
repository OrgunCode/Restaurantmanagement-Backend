/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Administrator;
import de.restaurant.restaurantserver.core.entities.Gast;
import de.restaurant.restaurantserver.core.entities.Restaurantmanager;
import de.restaurant.restaurantserver.core.entities.Restaurantmitarbeiter;
import de.restaurant.restaurantserver.core.entities.Tisch;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orgun
 */
@Stateless
public class BenutzerPflegen implements IBenutzerPflegen {

    @EJB
    BenutzerManager benutzerManager;
    @EJB
    GastManager gastManager;
    @EJB
    TischManager tischManager;

    @Override
    public Administrator adminAnlegen(String benutzererkennung, String passwort, String name, String telefonnummer) {

        Administrator administrator = new Administrator();

        administrator.setBenutzererkennung(benutzererkennung);
        administrator.setPasswort(passwort);
        administrator.setName(name);
        administrator.setTelefonnummer(telefonnummer);

        return benutzerManager.adminAnlegen(administrator);
    }

    @Override
    public Restaurantmanager managerAnlegen(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> tischnr) {
        
        List<Tisch> gefundeneTische = new ArrayList<>();

        for (Integer tischId : tischnr) {
            Tisch tisch = tischManager.tischSuchenPerPK(tischId);
            if (tisch == null) {
                return null;
            }
            gefundeneTische.add(tisch);
        }

        Restaurantmanager restaurantmanager = new Restaurantmanager();

        restaurantmanager.setBenutzererkennung(benutzererkennung);
        restaurantmanager.setPasswort(passwort);
        restaurantmanager.setName(name);
        restaurantmanager.setTelefonnummer(telefonnummer);
        for (Tisch t : gefundeneTische) {
            restaurantmanager.addTisch(t);
        }

        return benutzerManager.managerAnlegen(restaurantmanager);

    }

    @Override
    public Restaurantmitarbeiter mitarbeiterAnlegen(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> gastnr) {

        List<Gast> gefundeneGaeste = new ArrayList<>();

        for (Integer gastId : gastnr) {
            Gast gast = gastManager.gastSuchenPerPK(gastId);
            if (gast == null) {
                return null;
            }
            gefundeneGaeste.add(gast);
        }

        Restaurantmitarbeiter restaurantmitarbeiter = new Restaurantmitarbeiter();

        restaurantmitarbeiter.setBenutzererkennung(benutzererkennung);
        restaurantmitarbeiter.setPasswort(passwort);
        restaurantmitarbeiter.setName(name);
        restaurantmitarbeiter.setTelefonnummer(telefonnummer);
        for (Gast g : gefundeneGaeste) {
            restaurantmitarbeiter.addGast(g);
        }

        return benutzerManager.mitarbeiterAnlegen(restaurantmitarbeiter);

    }

    @Override
    public boolean adminAendern(String benutzererkennung, String passwort, String name, String telefonnummer) {
        
        Administrator administrator = benutzerManager.adminSuchenPerPK(benutzererkennung);
        if (administrator == null) {
            return false;
        }

        administrator.setPasswort(passwort);
        administrator.setName(name);
        administrator.setTelefonnummer(telefonnummer);

        return benutzerManager.adminAendern(administrator);
    }

    @Override
    public boolean managerAendern(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> tischnr) {
        List<Tisch> gefundeneTische = new ArrayList<>();
        Restaurantmanager restaurantmanager = benutzerManager.managerSuchenPerPK(benutzererkennung);
        if (restaurantmanager == null) {
            return false;
        }

        for (Integer tischId : tischnr) {
            Tisch tisch = tischManager.tischSuchenPerPK(tischId);
            if (tisch == null) {
                return false;
            }
            gefundeneTische.add(tisch);
        }

        restaurantmanager.setPasswort(passwort);
        restaurantmanager.setName(name);
        restaurantmanager.setTelefonnummer(telefonnummer);
        for (Tisch t : gefundeneTische) {
            restaurantmanager.addTisch(t);
        }

        return benutzerManager.managerAendern(restaurantmanager);
    }

    @Override
    public boolean mitarbeiterAendern(String benutzererkennung, String passwort, String name, String telefonnummer, List<Integer> gastnr) {
        List<Gast> gefundeneGaeste = new ArrayList<>();
        Restaurantmitarbeiter restaurantmitarbeiter = benutzerManager.mitarbeiterSuchenPerPK(benutzererkennung);
        if (restaurantmitarbeiter == null) {
            return false;
        }

        for (Integer gastId : gastnr) {
            Gast gast = gastManager.gastSuchenPerPK(gastId);
            if (gast == null) {
                return false;
            }
            gefundeneGaeste.add(gast);
        }

        restaurantmitarbeiter.setPasswort(passwort);
        restaurantmitarbeiter.setName(name);
        restaurantmitarbeiter.setTelefonnummer(telefonnummer);
        for (Gast g : gefundeneGaeste) {
            restaurantmitarbeiter.addGast(g);
        }

        return benutzerManager.mitarbeiterAendern(restaurantmitarbeiter);
    }

}
