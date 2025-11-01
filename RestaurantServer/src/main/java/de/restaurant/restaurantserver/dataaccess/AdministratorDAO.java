/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.dataaccess;

import de.restaurant.restaurantserver.core.entities.Administrator;
import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 *
 * @author orgun
 */
@Singleton
public class AdministratorDAO {
    
    @PersistenceContext
    private EntityManager em;

    public Administrator suchen(String benutzererkennung) {
        
        AdministratorEntity administratorEntity = em.find(AdministratorEntity.class,benutzererkennung);
        
        if (administratorEntity != null)
            return administratorEntity.toAdministrator();
        
        return null;
    }

    @Transactional
    public Administrator anlegen(Administrator administrator) {
        AdministratorEntity administratorEntity = new AdministratorEntity(administrator);
        em.persist(administratorEntity);

        return administratorEntity.toAdministrator();
    }
    
    @Transactional
    public boolean aendern(Administrator administrator) {
        AdministratorEntity administratorEntity = em.find(AdministratorEntity.class, administrator.getBenutzererkennung()); 

        if (administratorEntity == null) {
            return false;
        }

        administratorEntity.setPasswort(administrator.getPasswort());
        administratorEntity.setName(administrator.getName());
        administratorEntity.setTelefonnummer(administrator.getTelefonnummer());

        em.merge(administratorEntity);
        return true;
    }
    
    @Transactional
    public boolean loeschen(Administrator administrator) {
        AdministratorEntity administratorEntity = em.find(AdministratorEntity.class, administrator.getBenutzererkennung());

        if (administratorEntity == null) {
            return false;
        } else {
            em.remove(administratorEntity);
            return true;
        }
    }
}
