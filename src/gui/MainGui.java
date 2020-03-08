/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import client.Client;
import java.io.IOException;
import javafx.application.*;
import javafx.stage.*;

/**
 *
 * @author p1810879
 */
public class MainGui extends Application {

    public static Interfaceur appGui; //Permettra d'accéder à l'objet gérant les interfaces
    public static Client leClient; // Permet d'agir sur la classe client
    
    /**
     * Ouvre l'interface de connexion
     * @param primaryStage Stage initial de l'application
     * @throws java.lang.Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Création d'un objet de type interfaceur, qui gérera tous les changements de fenêtre
        Interfaceur newGui = new Interfaceur();
        MainGui.appGui = newGui;
        appGui.OpenConnectionStage(primaryStage);
    }
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
            if (args.length != 2) {
                printUsage();
            } else {
                String address = args[0];
                Integer port = new Integer(args[1]);
                Client c = new Client(address, port);
                MainGui.leClient = c;
                launch(args);
            }
        }
    
    private static void printUsage() {
        System.out.println("java client.Client <address> <port>");
        System.out.println("\t<address>: server's ip address");
        System.out.println("\t<port>: server's port");
    }
}
