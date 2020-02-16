/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.*;

/**
 *
 * @author Yannis
 */
public class Login_controller {
    @FXML private Text loginRslt;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    
    @FXML protected void tryLogin(ActionEvent event) {
        loginRslt.setText("Connexion en cours");
        // RECUPERATION USERNAME : usernameField.getText();
        // RECUPERATION PWD : passwordField.getText();
        
        /* Créer une classe qui interroge une BDD, vérifie l'existence de l'utilisateur, la validité du mdp, et valide ou non la connexion */
    }
}
