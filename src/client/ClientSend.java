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
        while (true) {
            /*System.out.print("Votre message >> ");
            String m = sc.nextLine();
            System.out.println(m);

            Message mess;
            // Message permettant de quitter le chat
            if(m.equals("exit")) mess = null;
            else mess = new Message("client", m);
            System.out.println(mess);
            out.writeObject(mess);
            out.flush();*/
        }
    }
    
    public void sendMessage(String message) throws IOException{
        Message mess;
        if(message.equals("exit")) mess = null;
        else mess = new Message("client", message);
        out.writeObject(mess);
        out.flush();
    }
    
    public void sendConnexionMessage(String pseudo) throws IOException{
        Message mess;
        if(pseudo.isEmpty()) pseudo = "Anonyme";
        mess = new Message("client", pseudo, 2);
        out.writeObject(mess);
        out.flush();
    }

    public void sendPrivateMessage(String message) throws IOException {
        Message mess;
        mess = new Message("client", message, 5);
        out.writeObject(mess);
        out.flush();
    }
}
