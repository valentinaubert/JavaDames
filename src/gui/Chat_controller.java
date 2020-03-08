package gui;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
/**
 *
 * @author Yannis
 */
public class Chat_controller {
    @FXML private ScrollPane scroll_ReceivedText;
    @FXML private TextArea textToSend;
    @FXML private TextFlow tf_ReceivedText;
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        String text = textToSend.getText();
        MainGui.leClient.sender.sendMessage(text);
        textToSend.clear();
    }
    
    @FXML protected void refreshChat(ActionEvent event){
        ArrayList<String> lesMessages = MainGui.leClient.getMsgEnAttente();
        for(String unMessage : lesMessages ){
            tf_ReceivedText.getChildren().add(new Text(unMessage));
        }
        MainGui.leClient.clearMsgEnAttente();
    }
}
