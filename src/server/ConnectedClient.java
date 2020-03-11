/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import common.Message;

/**
 *
 * @author p1810879
 */
public class ConnectedClient implements Runnable {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
        /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }
    private static int idCounter = 0;
    private int id;
    private String pseudo;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    protected Server server;
    
    public ConnectedClient(Server server, Socket socket) throws IOException{
        this.server = server;
        this.socket = socket;
        id = idCounter++;
        out = new ObjectOutputStream(socket.getOutputStream());
        System.out.println("Nouvelle connexion, id = " + id);
    }
    
    @Override
    public void run(){
        try {
            in = new ObjectInputStream(socket.getInputStream());
            boolean isActive = true;
            while (isActive) {
                Message mess = (Message) in.readObject();
                if(mess != null){
                    if(mess.getType() == 1){
                        mess.setSender(String.valueOf(getPseudo()));
                        server.broadcastMessage(mess,id);
                    }
                    else if(mess.getType() == 2){
                        this.pseudo = mess.getContent();
                        Message msgConnexion = new Message("Server", this.getPseudo() + " vient de se connecter",3);
                        server.broadcastMessage(msgConnexion, id);
                    }
                }
                else{
                    server.disconnectedClient(this);
                    isActive = false;
                }
            }
        } catch (IOException ex) { // comprend les EOFException
            Logger.getLogger(ConnectedClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectedClient.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void sendMessage(Message mess) throws IOException{
        this.out.writeObject(mess);
        this.out.flush();
    }
    
    public void closeClient() throws IOException{
        this.in.close();
        this.out.close();
       this.socket.close();
    }


}
