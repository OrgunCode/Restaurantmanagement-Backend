/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Tisch;
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
public class TischDAO {

    @PersistenceContext
    private EntityManager em;

    public Tisch suchen(int nummer) {

        TischEntity tischEntity = em.find(TischEntity.class, nummer);

        if (tischEntity == null) {
            return null;
        } else {
            return tischEntity.toTisch();
        }
    }

    @Transactional
    public Tisch anlegen(Tisch tisch) {
        TischEntity tischEntity = new TischEntity(tisch); // Annahme: TischEntity hat einen Konstruktor, der ein Tisch-Objekt nimmt
        em.persist(tischEntity);

        return tischEntity.toTisch();
    }
    
    @Transactional
    public boolean aendern(Tisch tisch) {
        TischEntity tischEntity = em.find(TischEntity.class, tisch.getNummer());

        if (tischEntity == null) {
            return false;
        }

        // Aktualisiere Felder
        tischEntity.setAnzahlPlaetze(tisch.getAnzahlPlaetze());
        tischEntity.setLage(tisch.getLage());
        tischEntity.setTischstatus(tisch.getTischstatus());

        em.merge(tischEntity);
        return true;
    }

    @Transactional
    public boolean loeschen(Tisch tisch) {
        TischEntity tischEntity = em.find(TischEntity.class, tisch.getNummer());

        if (tischEntity == null) {
            return false;
        } else {
            em.remove(tischEntity);
            return true;
        }
    }

    public List<Tisch> suchen(Tisch suchTisch) {
        StringBuilder queryString = new StringBuilder("SELECT t FROM TischEntity t");
        boolean firstCondition = true;

        if (suchTisch != null) {
            if (suchTisch.getTischstatus()!= null) {
                if (firstCondition) { queryString.append(" WHERE "); firstCondition = false; } else { queryString.append(" AND "); }
                queryString.append("t.tischstatus = :tischstatus");
            }
        }

        TypedQuery<TischEntity> query = em.createQuery(queryString.toString(), TischEntity.class);
        
        if (suchTisch != null && suchTisch.getTischstatus() != null) {
            query.setParameter("tischstatus", suchTisch.getTischstatus());
        }
        
        return query.getResultList().stream()
                .map(TischEntity::toTisch)
                .collect(Collectors.toList());
    }
}
