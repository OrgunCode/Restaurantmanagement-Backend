/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Gast;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 *
 * @author orgun
 */
@Singleton
public class GastDAO {
    
    @PersistenceContext
    private EntityManager em;

    public Gast suchen(int kundennummer) {
        
        GastEntity gastEntity = em.find(GastEntity.class,kundennummer);
        
        if (gastEntity == null)
            return null;
        else
            return gastEntity.toGast();
    }
    
    @Transactional
    public Gast anlegen(Gast gast) {
        GastEntity gastEntity = new GastEntity(gast);
        em.persist(gastEntity);

        return gastEntity.toGast();
    }
    
    @Transactional
    public boolean aendern(Gast gast) {
        GastEntity gastEntity = em.find(GastEntity.class, gast.getKundennummer()); // Annahme: Gast hat getKundennummer()

        if (gastEntity == null) {
            return false;
        }

        // Aktualisiere Felder
        gastEntity.setName(gast.getName());
        gastEntity.setAdresse(gast.getAdresse());
        gastEntity.setTelefonnummer(gast.getTelefonnummer());
        gastEntity.setEMailAdresse(gast.getEMailAdresse());
        gastEntity.setGeburtsdatum(gast.getGeburtsdatum());
        gastEntity.setVorlieben(gast.getVorlieben());

        em.merge(gastEntity);
        return true;
    }
    
    @Transactional
    public boolean loeschen(Gast gast) {
        GastEntity gastEntity = em.find(GastEntity.class, gast.getKundennummer());

        if (gastEntity == null) {
            return false;
        } else {
            em.remove(gastEntity);
            return true;
        }
    }

}
