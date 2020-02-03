/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 *
 * @author p1810879
 */
public class MainGui extends Application {

    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            URL location = getClass().getResource("Chat_interface.fxml");
            FXMLLoader fxmlloader = new FXMLLoader(location);
            Pane root = (Pane) fxmlloader.load();
            //Group group = new Group();
            Scene scene = new Scene(root);
            primaryStage.setTitle("Super chat");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
