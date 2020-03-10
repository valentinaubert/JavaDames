/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.Message;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author p1810879
 */
public class ClientReceive implements Runnable {

    private Client client;
    private ObjectInputStream in;
    private Socket socket;
    
    public ClientReceive(Client client, Socket socket) {
        this.client = client;
        this.socket = socket;
    }
    
    @Override
    public void run(){
        try {
            this.in = new ObjectInputStream(this.socket.getInputStream());
            boolean isActive = true;
            while(isActive) {
                Message mess = (Message) in.readObject();
                if (mess != null) {
                    this.client.messageReceived(mess);
                } else {
                    isActive = false;
                }
            }
            client.disconnectedServer();
        } 
        catch (EOFException ex) {
            try {
                client.disconnectedServer();
            } catch (IOException ex1) {
                Logger.getLogger(ClientReceive.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
           Logger.getLogger(ClientReceive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClientReceive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
