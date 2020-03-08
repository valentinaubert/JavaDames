/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Yannis
 */
public class Interfaceur {
    private Stage connectionStage;
    private Stage chatStage;
    
    /**
     * Constructeur de la classe. Permet juste d'instancier la classe
     */
    public Interfaceur(){}
    
    /**
     * Ouvre l'interface de connexion et conserve le stage utilisé dans l'attribut privé connectionStage
     * @param connectionStage Utilise un stage déjà existant (idéalement le primaryStage)
     */
    public void OpenConnectionStage(Stage connectionStage) throws IOException{
        URL location = getClass().getResource("Login_interface.fxml");
        FXMLLoader fxmlloader = new FXMLLoader(location);
        Pane root = (Pane) fxmlloader.load();
        Scene scene = new Scene(root);
        connectionStage.setTitle("Connexion au chat");
        connectionStage.setScene(scene);
        connectionStage.show();
        this.connectionStage = connectionStage;
    }
    
    /**
     * Ouvre l'interface de chat, et conserve le stage créé dans l'attribut privé chatStage
     */
    public void OpenChatStage() throws IOException{
        URL location = getClass().getResource("Chat_interface.fxml");
        FXMLLoader fxmlloader = new FXMLLoader(location);
        Pane root = (Pane) fxmlloader.load();
        Scene scene = new Scene(root);
        Stage fenetreChat = new Stage();
        fenetreChat.setTitle("Chat");
        fenetreChat.setScene(scene);
        fenetreChat.show();
        this.chatStage = fenetreChat;
    }
    
    /**
     * Ferme l'interface de connexion
     */
    public void CloseConnectionStage(){
        if(null != this.connectionStage) {
            this.connectionStage.close();
            this.connectionStage = null;
        }
    }
    
    /**
     * Ferme l'interface de chat
     */
    public void CloseChatStage(){
        if(null != this.chatStage) {
            this.chatStage.close();
            this.chatStage = null;
        }
    }
}
