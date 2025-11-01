/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Restaurantmanager;
import de.restaurant.restaurantserver.core.entities.Tisch;
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
public class RestaurantmanagerDAO {
    
    @PersistenceContext
    private EntityManager em;

    public Restaurantmanager suchen(String benutzererkennung) {
        
        RestaurantmanagerEntity restaurantmanagerEntity = em.find(RestaurantmanagerEntity.class,benutzererkennung);
        
        if (restaurantmanagerEntity != null)
            return restaurantmanagerEntity.toRestaurantmanager();
        
        return null;
    }
     
    @Transactional
    public Restaurantmanager anlegen(Restaurantmanager manager) {
        RestaurantmanagerEntity managerEntity = new RestaurantmanagerEntity(manager);
        em.persist(managerEntity);

        return managerEntity.toRestaurantmanager();
    }
    
    @Transactional
    public boolean aendern(Restaurantmanager manager) {
        RestaurantmanagerEntity managerEntity = em.find(RestaurantmanagerEntity.class, manager.getBenutzererkennung());

        if (managerEntity == null) {
            return false;
        }

        managerEntity.setPasswort(manager.getPasswort());
        managerEntity.setName(manager.getName());
        managerEntity.setTelefonnummer(manager.getTelefonnummer());

        if (managerEntity.getTischentity() != null) {
            managerEntity.getTischentity().clear();
        } else {
            managerEntity.setTischentity(new ArrayList<>());
        }

        if (manager.getTische() != null) {
            for (Tisch neuerTisch : manager.getTische()) {
                TischEntity tischEntity = em.find(TischEntity.class, neuerTisch.getNummer());
                if (tischEntity != null) {
                    managerEntity.getTischentity().add(tischEntity);
                } //else {
                   //System.err.println("Warnung: Tisch mit Nummer " + neuerTisch.getNummer() + " für Manager " + manager.getBenutzererkennung() + " nicht gefunden. Wird ignoriert.");
                //}
            }
        }

        em.merge(managerEntity);
        return true;
    }
    
    @Transactional
    public boolean loeschen(Restaurantmanager manager) {
        RestaurantmanagerEntity managerEntity = em.find(RestaurantmanagerEntity.class, manager.getBenutzererkennung());

        if (managerEntity == null) {
            return false;
        } else {
            em.remove(managerEntity);
            return true;
        }
    }
}
