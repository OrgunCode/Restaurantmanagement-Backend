/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Tisch;
import de.restaurant.restaurantserver.core.enumeration.LageT;
import de.restaurant.restaurantserver.core.enumeration.TischstatusT;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

/**
 *
 * @author orgun
 */
@Stateless
public class TischPflegen implements ITischPflegen {

    @EJB
    TischManager tischManager;

    @Override
    public Tisch tischAnlegen(int nummer, int anzahlPlaetze, String lage, String tischstatus) {

        Tisch tisch = new Tisch();

        tisch.setNummer(nummer);
        tisch.setAnzahlPlaetze(anzahlPlaetze);
        tisch.setLage(LageT.valueOf(lage.trim().toUpperCase()));
        tisch.setTischstatus(TischstatusT.valueOf(tischstatus.trim().toUpperCase()));

        return tischManager.tischAnlegen(tisch);
    }

    @Override
    public boolean tischAendern(int nummer, int anzahlPlaetze, String lage, String tischstatus){
        Tisch tisch = tischManager.tischSuchenPerPK(nummer);
        if (tisch == null) {
            return false;
        }
        
        tisch.setAnzahlPlaetze(anzahlPlaetze);
        tisch.setLage(LageT.valueOf(lage.trim().toUpperCase()));
        tisch.setTischstatus(TischstatusT.valueOf(tischstatus.trim().toUpperCase()));
        
        return tischManager.tischAendern(tisch);
    }
}
