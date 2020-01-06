package common;

import java.io.Serializable;

/**
 *
 * @author p1810879
 */
public class Message implements Serializable{
    private String sender;
    private String content;
    
    public Message(String sender, String content){
        this.sender = sender;
        this.content = content;
    }
    
    @Override
    public String toString(){
        return "De : " + getSender() + " --- " + content;
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
    
}
