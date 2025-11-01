/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Bestellung;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author orgun
 */
@Singleton
public class BestellungDAO {
    
    @PersistenceContext
    private EntityManager em;

    public Bestellung suchen(int bestellnummer) {
        
        BestellungEntity bestellungEntity = em.find(BestellungEntity.class,bestellnummer);
        
        if (bestellungEntity == null)
            return null;
        else
            return bestellungEntity.toBestellung();
    }
    
    @Transactional
    public Bestellung anlegen(Bestellung bestellung) {
        BestellungEntity bestellungEntity = new BestellungEntity(bestellung);
        em.persist(bestellungEntity);

        return bestellungEntity.toBestellung();
    }
    
    @Transactional
    public boolean aendern(Bestellung bestellung) {
        BestellungEntity bestellungEntity = em.find(BestellungEntity.class, bestellung.getBestellnummer());

        if (bestellungEntity == null) {
            return false;
        }

        bestellungEntity.setBestellposition(bestellung.getBestellposition());
        bestellungEntity.setGesamtbetrag(bestellung.getGesamtbetrag());
        bestellungEntity.setBestellzeitpunkt(bestellung.getBestellzeitpunkt());
        bestellungEntity.setBestellstatus(bestellung.getBestellstatus());

        em.merge(bestellungEntity);
        return true;
    }
    
    @Transactional
    public boolean loeschen(Bestellung bestellung) {
        BestellungEntity bestellungEntity = em.find(BestellungEntity.class, bestellung.getBestellnummer());

        if (bestellungEntity == null) {
            return false;
        } else {
            em.remove(bestellungEntity);
            return true;
        }
    }
    
    public List<Bestellung> suchen(Bestellung suchBestellung) {
        StringBuilder queryString = new StringBuilder("SELECT b FROM BestellungEntity b");
        boolean firstCondition = true;

        if (suchBestellung != null) {
            if (suchBestellung.getBestellstatus() != null) {
                if (firstCondition) { queryString.append(" WHERE "); firstCondition = false; } else { queryString.append(" AND "); }
                queryString.append("b.bestellstatus = :bestellstatus");
            }
        }

        TypedQuery<BestellungEntity> query = em.createQuery(queryString.toString(), BestellungEntity.class);

        if (suchBestellung != null && suchBestellung.getBestellstatus() != null) {
            query.setParameter("bestellstatus", suchBestellung.getBestellstatus());
        }

        return query.getResultList().stream()
                .map(BestellungEntity::toBestellung)
                .collect(Collectors.toList());
    }
}
