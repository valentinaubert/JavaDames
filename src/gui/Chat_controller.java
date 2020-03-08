package gui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.text.*;
/**
 *
 * @author Yannis
 */
public class Chat_controller {
    @FXML private ScrollPane scroll_ReceivedText;
    @FXML private TextArea textToSend;
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
        //scroll_ReceivedText.setContent(new TextFlow(new Text("Sign in button pressed")));
        String text = textToSend.getText();
        MainGui.leClient.sender.sendMessage(text);
        textToSend.clear();
    }
}
