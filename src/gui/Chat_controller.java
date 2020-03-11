package gui;

import common.Message;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
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
        if(text.startsWith("/")) MainGui.leClient.sender.sendPrivateMessage(text);
        else MainGui.leClient.sender.sendMessage(text);
        textToSend.clear();
        MainGui.appGui.receptionMessage(new Message("Moi",text,4));
    }
    
    @FXML protected void clearChat(ActionEvent event) throws IOException {
        tf_ReceivedText.getChildren().clear();
    }
}
