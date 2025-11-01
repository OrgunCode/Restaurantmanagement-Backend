/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

/**
 *
 * @author orgun
 */
public record AdminTO(
    String benutzererkennung,
    String passwort,
    String name,
    String telefonnummer) 
{}
