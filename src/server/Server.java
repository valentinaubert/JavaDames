package server;

import common.Message;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author p1810879
 */
public class Server {
    private int port;
    private List<ConnectedClient> clients;
    
    public Server(int port) throws IOException{
        this.port = port;
        this.clients = new ArrayList<>();
        Thread threadConnection = new Thread(new Connection(this));
        threadConnection.start();
    }

    /**
     * @return the port
     */
    public int getPort() {
        return port;
    }
    
    public void addClient(ConnectedClient newClient) throws IOException{
        this.clients.add(newClient);
    }
    
    public void broadcastMessage(Message mess, int id) throws IOException{
        for(ConnectedClient client : clients){
            if(client.getId() != id) {
                client.sendMessage(mess);
            }
        }
    }
    
    public void disconnectedClient(ConnectedClient discClient) throws IOException{
        discClient.closeClient();
        for(ConnectedClient client : clients) {
            if (client.getId() != discClient.getId()) {
                client.sendMessage(new Message("Server", "Le client " + discClient.getPseudo() + " nous a quitté",3));
            }
        }
        clients.remove(discClient);
    }
    
}
