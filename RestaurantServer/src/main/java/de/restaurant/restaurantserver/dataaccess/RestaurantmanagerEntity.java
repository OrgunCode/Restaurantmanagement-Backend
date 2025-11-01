/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Benutzer;
import de.restaurant.restaurantserver.core.entities.Restaurantmanager;
import de.restaurant.restaurantserver.core.entities.Tisch;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author orgun
 */
@Entity
public class RestaurantmanagerEntity extends BenutzerEntity {
    
    @OneToMany
    @JoinColumn(name="TISCHNR", referencedColumnName = "TISCHNR")
    private List<TischEntity> tischentity;
    
    public RestaurantmanagerEntity(){
        
    }

    public RestaurantmanagerEntity(Restaurantmanager restaurantmanager) {
        super(new Benutzer(restaurantmanager.getBenutzererkennung(), restaurantmanager.getPasswort(), restaurantmanager.getName(), restaurantmanager.getTelefonnummer()));
        for (Tisch t : restaurantmanager.getTische()){
            this.tischentity.add(new TischEntity(t));
        }
    }
     
    public Restaurantmanager toRestaurantmanager() {
        List<Tisch> tischListe = new ArrayList<>();
        
        for (TischEntity t : tischentity){
            tischListe.add(new Tisch(t.getNummer(), t.getAnzahlPlaetze(), t.getLage(), t.getTischstatus()));
        }
        return new Restaurantmanager(this.getBenutzererkennung(), this.getPasswort(), this.getName(), this.getTelefonnummer(), tischListe);
    }

    public List<TischEntity> getTischentity() {
        return tischentity;
    }

    public void setTischentity(List<TischEntity> tischentity) {
        this.tischentity = tischentity;
    }
    
    
}
