/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import common.Message;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
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
        // Action de fermeture de l'application
        connectionStage.setOnCloseRequest(event -> {
            try {
                MainGui.leClient.sender.sendMessage("exit");
            } catch (IOException ex) {
                Logger.getLogger(Interfaceur.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
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
        
        // Action de fermeture de l'application
        fenetreChat.setOnCloseRequest(event -> {
            try {
                MainGui.leClient.sender.sendMessage("exit");
            } catch (IOException ex) {
                Logger.getLogger(Interfaceur.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        fenetreChat.show();
        this.chatStage = fenetreChat;
        
        //Adaptation du défilement du ScrollPane à la taille du TextFlow
        TextFlow receivedText = (TextFlow) fenetreChat.getScene().lookup("#tf_ReceivedText");
        ScrollPane scrollReceivedText = (ScrollPane) fenetreChat.getScene().lookup("#scroll_ReceivedText");
        scrollReceivedText.vvalueProperty().bind(receivedText.heightProperty());
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
    
    public void receptionMessage(Message mess){
        Text nouveauMessage = new Text(mess.toString() + " \n");
        if(mess.getType() == 3) { 
            nouveauMessage.setStyle("-fx-font-style: italic;");
            nouveauMessage.setFill(Color.GRAY);
        }
        else if(mess.getType() == 4) nouveauMessage.setFill(Color.BLUE);;
        
        TextFlow receivedText = (TextFlow) this.chatStage.getScene().lookup("#tf_ReceivedText");
        receivedText.getChildren().add(nouveauMessage);
    }
}
