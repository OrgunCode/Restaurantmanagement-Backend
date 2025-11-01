/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package de.restaurant.restaurantserver.core.usecases;

import de.restaurant.restaurantserver.core.entities.Administrator;
import de.restaurant.restaurantserver.core.entities.Restaurantmanager;
import de.restaurant.restaurantserver.core.entities.Restaurantmitarbeiter;
import jakarta.ejb.Local;

/**
 *
 * @author orgun
 */
@Local
public interface IBenutzerSuchen {

    public Administrator adminSuchenPerPK(String benutzererkennung);

    public Restaurantmanager managerSuchenPerPK(String benutzererkennung);

    public Restaurantmitarbeiter mitarbeiterSuchenPerPK(String benutzererkennung);
}
