/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.stage.Stage;

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
        URL location = getClass().getResource("Chat_interface.fxml");
        FXMLLoader fxmlloader = new FXMLLoader(location);
        Pane root = (Pane) fxmlloader.load();
        Scene scene = new Scene(root);
        Stage fenetreChat = new Stage();
        fenetreChat.setTitle("Chat");
        fenetreChat.setScene(scene);
        fenetreChat.show();
        MainGui.setChatStage(fenetreChat);
        
        // Fermeture de la fenêtre de login
        Stage primaryStage = MainGui.getConnectionStage();
        primaryStage.close();
        
        
    }
}
