/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import client.Client;
import client.Client;
import client.Client;
import java.io.IOException;
import java.net.URL;
import java.net.UnknownHostException;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 *
 * @author p1810879
 */
public class MainGui extends Application {

    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            URL location = getClass().getResource("Login_interface.fxml");
            FXMLLoader fxmlloader = new FXMLLoader(location);
            Pane root = (Pane) fxmlloader.load();
            //Group group = new Group();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Connexion au chat");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                printUsage();
            } else {
                String address = args[0];
                Integer port = new Integer(args[1]);
                Client c = new Client(address, port);
                launch(args);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    private static void printUsage() {
        System.out.println("java client.Client <address> <port>");
        System.out.println("\t<address>: server's ip address");
        System.out.println("\t<port>: server's port");
    }
}
