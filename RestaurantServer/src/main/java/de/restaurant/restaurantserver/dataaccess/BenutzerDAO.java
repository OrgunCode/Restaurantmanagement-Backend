/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Benutzer;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 *
 * @author orgun
 */
@Singleton
public class BenutzerDAO {
    
    @PersistenceContext
    private EntityManager em;

    public Benutzer suchen(String benutzererkennung) {
        
        BenutzerEntity benutzerEntity = em.find(BenutzerEntity.class,benutzererkennung);
        
        if (benutzerEntity != null)
            return benutzerEntity.toBenutzer();
        
        return null;
    }
    
    @Transactional
    public Benutzer anlegen(Benutzer benutzer) {
        BenutzerEntity benutzerEntity = new BenutzerEntity(benutzer); // Annahme: BenutzerEntity hat einen Konstruktor, der ein Benutzer-Objekt nimmt
        em.persist(benutzerEntity);

        return benutzerEntity.toBenutzer();
    }
    
    @Transactional
    public boolean aendern(Benutzer benutzer) {
        BenutzerEntity benutzerEntity = em.find(BenutzerEntity.class, benutzer.getBenutzererkennung()); // Annahme: Benutzer hat getBenutzererkennung()

        if (benutzerEntity == null) {
            return false;
        }
        
        benutzerEntity.setPasswort(benutzer.getPasswort());
        benutzerEntity.setName(benutzer.getName());
        benutzerEntity.setTelefonnummer(benutzer.getTelefonnummer());

        em.merge(benutzerEntity);
        return true;
    }
    
    @Transactional
    public boolean loeschen(Benutzer benutzer) {
        BenutzerEntity benutzerEntity = em.find(BenutzerEntity.class, benutzer.getBenutzererkennung());

        if (benutzerEntity == null) {
            return false;
        } else {
            em.remove(benutzerEntity);
            return true;
        }
    }
}
