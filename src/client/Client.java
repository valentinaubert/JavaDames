/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import common.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author p1810879
 */
public class Client {
    private int port;
    private String address;
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    public ClientSend sender;
    private ArrayList<String> msgEnAttente;
    
    public Client(String address, int port) throws UnknownHostException, IOException{
        this.port = port;
        this.address = address;
        InetAddress ipAddress = InetAddress.getByName(address);
        this.socket = new Socket(ipAddress, port);
        this.out = new ObjectOutputStream(this.socket.getOutputStream());
        this.sender = new ClientSend(socket,out);
        this.msgEnAttente = new ArrayList();
        Thread threadClientSend = new Thread(this.sender);
        Thread threadClientReceive = new Thread(new ClientReceive(this,socket));
        threadClientSend.start();
        threadClientReceive.start();
    }
    
    public void disconnectedServer() throws IOException{
        if(out != null) { out.close(); }
        if(socket != null) { socket.close(); }
        if(in != null) { in.close(); }
        System.exit(0);
    }
    
    public void messageReceived(Message mess){
        this.msgEnAttente.add(mess.toString());
    }

    /**
     * @return the msgEnAttente
     */
    public ArrayList<String> getMsgEnAttente() {
        return msgEnAttente;
    }

    /**
     * Vide la liste de messages en attente
     */
    public void clearMsgEnAttente() {
        this.msgEnAttente.clear();
    }
}
