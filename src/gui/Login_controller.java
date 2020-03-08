/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
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
    
    @FXML protected void tryLogin(ActionEvent event) throws IOException {
        loginRslt.setText("Connexion en cours");
        // RECUPERATION USERNAME : usernameField.getText();
        // RECUPERATION PWD : passwordField.getText();
        String userName = usernameField.getText();
        String password = passwordField.getText();
        
        /* Créer une classe qui interroge une BDD, vérifie l'existence de l'utilisateur, la validité du mdp, et valide ou non la connexion */
        
        // Ouverture d'une nouvelle fenêtre contenant le chat
        MainGui.appGui.OpenChatStage();
        
        // Fermeture de la fenêtre de login
        MainGui.appGui.CloseConnectionStage();
    }
}
