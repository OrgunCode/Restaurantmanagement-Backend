/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Gast;
import de.restaurant.restaurantserver.core.entities.Restaurantmitarbeiter;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.ArrayList;

/**
 *
 * @author orgun
 */
@Singleton
public class RestaurantmitarbeiterDAO {
    
    @PersistenceContext
    private EntityManager em;

    public Restaurantmitarbeiter suchen(String benutzererkennung) {
        
        RestaurantmitarbeiterEntity restaurantmitarbeiterEntity = em.find(RestaurantmitarbeiterEntity.class,benutzererkennung);
        
        if (restaurantmitarbeiterEntity != null)
            return restaurantmitarbeiterEntity.toRestaurantmitarbeiter();
        
        return null;
    }
      
    @Transactional
    public Restaurantmitarbeiter anlegen(Restaurantmitarbeiter mitarbeiter) {
        RestaurantmitarbeiterEntity mitarbeiterEntity = new RestaurantmitarbeiterEntity(mitarbeiter);
        em.persist(mitarbeiterEntity);

        return mitarbeiterEntity.toRestaurantmitarbeiter();
    }
    
    @Transactional
    public boolean aendern(Restaurantmitarbeiter mitarbeiter) {
        RestaurantmitarbeiterEntity mitarbeiterEntity = em.find(RestaurantmitarbeiterEntity.class, mitarbeiter.getBenutzererkennung());

        if (mitarbeiterEntity == null) {
            return false;
        }

        mitarbeiterEntity.setPasswort(mitarbeiter.getPasswort());
        mitarbeiterEntity.setName(mitarbeiter.getName());
        mitarbeiterEntity.setTelefonnummer(mitarbeiter.getTelefonnummer());

        if (mitarbeiterEntity.getGastentity() != null) {
            mitarbeiterEntity.getGastentity().clear();
        } else {
            mitarbeiterEntity.setGastentity(new ArrayList<>());
        }

        if (mitarbeiter.getGaeste() != null) {
            for (Gast neuerGast : mitarbeiter.getGaeste()) {
                GastEntity gastEntity = em.find(GastEntity.class, neuerGast.getKundennummer());
                if (gastEntity != null) {
                    mitarbeiterEntity.getGastentity().add(gastEntity);
                } //else {
                    //System.err.println("Warnung: Gast mit Kundennummer " + neuerGast.getKundennummer() + " für Mitarbeiter " + mitarbeiter.getBenutzererkennung() + " nicht gefunden. Wird ignoriert.");
               // }
            }
        }

        em.merge(mitarbeiterEntity);
        return true;
    }
    
    @Transactional
    public boolean loeschen(Restaurantmitarbeiter mitarbeiter) {
        RestaurantmitarbeiterEntity mitarbeiterEntity = em.find(RestaurantmitarbeiterEntity.class, mitarbeiter.getBenutzererkennung());

        if (mitarbeiterEntity == null) {
            return false;
        } else {
            em.remove(mitarbeiterEntity);
            return true;
        }
    }
}
