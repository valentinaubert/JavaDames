/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import client.Client;
import java.io.IOException;
import java.net.UnknownHostException;
import javafx.application.*;
import javafx.stage.*;

/**
 *
 * @author p1810879
 */
public class MainGui extends Application {

    public static Interfaceur appGui; //Permettra d'accéder à l'objet gérant les interfaces
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Création d'un objet de type interfaceur, qui gérera tous les changements de fenêtre
        Interfaceur newGui = new Interfaceur();
        MainGui.appGui = newGui;
        appGui.OpenConnectionStage(primaryStage);
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
