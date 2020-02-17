/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.Message;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p1810879
 */
public class ClientSend implements Runnable {

    private ObjectOutputStream out;
    private Socket socket;
    
    public ClientSend(Socket socket, ObjectOutputStream out) {
        this.socket = socket;
        this.out = out;
    }
    
    @Override
    public void run(){
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Votre message >> ");
                String m = sc.nextLine();
                System.out.println(m);
                Message mess;
                // Message permettant de quitter le chat
                if(m.equals("exit")) mess = null;
                else mess = new Message("client", m);
                System.out.println(mess);
                out.writeObject(mess);
                out.flush();
            }             
        } catch (IOException ex) {
                Logger.getLogger(ClientSend.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    
    
}
