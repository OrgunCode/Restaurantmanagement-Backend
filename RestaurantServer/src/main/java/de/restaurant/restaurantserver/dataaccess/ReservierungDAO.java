/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Reservierung;
import de.restaurant.restaurantserver.core.entities.Tisch;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author orgun
 */
@Singleton
public class ReservierungDAO {
    
    @PersistenceContext
    private EntityManager em;

    public Reservierung suchen(int reservierungsnummer) {
        
        ReservierungEntity reservierungEntity = em.find(ReservierungEntity.class,reservierungsnummer);
        
        if (reservierungEntity == null)
            return null;
        else
            return reservierungEntity.toReservierung();
    }
    
    @Transactional
    public Reservierung anlegen(Reservierung reservierung) {
        ReservierungEntity reservierungEntity = new ReservierungEntity(reservierung); // Annahme: ReservierungEntity hat einen Konstruktor, der ein Reservierung-Objekt nimmt
        em.persist(reservierungEntity);

        return reservierungEntity.toReservierung();
    }
    
    @Transactional
    public boolean aendern(Reservierung reservierung) {
        ReservierungEntity reservierungEntity = em.find(ReservierungEntity.class, reservierung.getReservierungsnummer()); // Annahme: Reservierung hat getReservierungsnummer()

        if (reservierungEntity == null) {
            return false;
        }

        // Aktualisiere Felder
        reservierungEntity.setReservierungsdatum(reservierung.getReservierungsdatum());
        reservierungEntity.setReservierungsuhrzeit(reservierung.getReservierungsuhrzeit());
        reservierungEntity.setAnzahlDerPersonen(reservierung.getAnzahlDerPersonen());
        reservierungEntity.setWunsch(reservierung.getWunsch());
        reservierungEntity.setReservierungsstatus(reservierung.getReservierungsstatus());
        
        if (reservierungEntity.getTischentity() != null) {
            reservierungEntity.getTischentity().clear();
        } else {
            reservierungEntity.setTischentity(new ArrayList<>());
        }

        if (reservierung.getTische() != null) {
            for (Tisch neuerTisch : reservierung.getTische()) {
                TischEntity tischEntity = em.find(TischEntity.class, neuerTisch.getNummer());
                if (tischEntity != null) {
                    reservierungEntity.getTischentity().add(tischEntity);
                } //else {
                    //System.err.println("Warnung: Tisch mit Nummer " + neuerTisch.getNummer() + " nicht gefunden. Wird ignoriert.");
                //}
            }
        }

        em.merge(reservierungEntity);
        return true;
    }
    
    @Transactional
    public boolean loeschen(Reservierung reservierung) {
        ReservierungEntity reservierungEntity = em.find(ReservierungEntity.class, reservierung.getReservierungsnummer());

        if (reservierungEntity == null) {
            return false;
        } else {
            em.remove(reservierungEntity);
            return true;
        }
    }
    
    public List<Reservierung> suchen(Reservierung suchReservierung) {
        StringBuilder queryString = new StringBuilder("SELECT r FROM ReservierungEntity r");
        boolean firstCondition = true;

        if (suchReservierung != null) {/*
            if (suchReservierung.getReservierungsdatum()!= null) {
                if (firstCondition) { queryString.append(" WHERE "); firstCondition = false; } else { queryString.append(" AND "); }
                queryString.append("r.reservierungsdatum = :reservierungsdatum");
            }
            if (suchReservierung.getReservierungsuhrzeit()!= null) {
                if (firstCondition) { queryString.append(" WHERE "); firstCondition = false; } else { queryString.append(" AND "); }
                queryString.append("r.reservierungsuhrzeit = :reservierungsuhrzeit");
            }*/
            if (suchReservierung.getReservierungsstatus()!= null) {
                if (firstCondition) { queryString.append(" WHERE "); firstCondition = false; } else { queryString.append(" AND "); }
                queryString.append("r.reservierungsstatus = :reservierungsstatus");
            }
        }

        TypedQuery<ReservierungEntity> query = em.createQuery(queryString.toString(), ReservierungEntity.class);
/*
        if (suchReservierung != null && suchReservierung.getReservierungsdatum()!= null) {
            query.setParameter("reservierungsdatum", suchReservierung.getReservierungsdatum());
        }
        
        if (suchReservierung != null && suchReservierung.getReservierungsuhrzeit()!= null) {
            query.setParameter("reservierungsuhrzeit", suchReservierung.getReservierungsuhrzeit());
        }
        */
        if (suchReservierung != null && suchReservierung.getReservierungsstatus()!= null) {
            query.setParameter("reservierungsstatus", suchReservierung.getReservierungsstatus());
        }

        return query.getResultList().stream()
                .map(ReservierungEntity::toReservierung)
                .collect(Collectors.toList());
    }
}
