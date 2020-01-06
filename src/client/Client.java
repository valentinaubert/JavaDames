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
    
    public Client(String address, int port) throws UnknownHostException, IOException{
        this.port = port;
        this.address = address;
        InetAddress ipAddress = InetAddress.getByName(address);
        this.socket = new Socket(ipAddress, port);
        this.out = new ObjectOutputStream(this.socket.getOutputStream());
        Thread threadClientSend = new Thread(new ClientSend(socket,out));
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
        System.out.println(mess);
    }
}
