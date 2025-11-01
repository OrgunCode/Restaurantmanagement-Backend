/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package de.restaurant.restaurantserver.facade;

import de.restaurant.restaurantserver.core.usecases.IBenutzerEinloggen;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.security.enterprise.credential.UsernamePasswordCredential;
import jakarta.security.enterprise.identitystore.CredentialValidationResult;
import static jakarta.security.enterprise.identitystore.CredentialValidationResult.INVALID_RESULT;
import jakarta.security.enterprise.identitystore.IdentityStore;
import java.util.Set;

/**
 *
 * @author orgun
 */
@Stateless
public class RestaurantIdentityStore implements IdentityStore {
    
    @EJB IBenutzerEinloggen benutzerEinloggen;
    
     public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        
         String benutzererkennung = usernamePasswordCredential.getCaller();
         String passwort = usernamePasswordCredential.getPasswordAsString();
         
         Boolean loginOK =  benutzerEinloggen.login(benutzererkennung, passwort);
         
         if (loginOK)
             return new CredentialValidationResult(benutzererkennung, Set.of("benutzer"));
         else
             return INVALID_RESULT;
         
    }
}