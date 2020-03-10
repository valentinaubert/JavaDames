package common;

import java.io.Serializable;

/**
 *
 * @author p1810879
 */
public class Message implements Serializable{
    private String sender;
    private String content;
    
    /***
     * 1 = message textuel
     * 2 = connexion
     */
    private int type;
    
    /***
     * Constructeur de messages textuels
     * @param sender
     * @param content 
     */
    public Message(String sender, String content){
        this.sender = sender;
        this.content = content;
        this.type = 1;
    }
    
    /***
     * Constructeur de messages spéciaux
     * @param sender
     * @param content
     * @param type
     */
    public Message(String sender, String content, int type){
        this.sender = sender;
        this.content = content;
        this.type = type;
    }
    
    @Override
    public String toString(){
        return "De : " + getSender() + " --- " + getContent();
    }

    /**
     * @return the sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * @param sender the sender to set
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    
}
