package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {

    @FXML
    public void handleHomeButton(ActionEvent event){
        // TODO
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/MainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCheckoutButton(ActionEvent event){
        // TODO
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/CheckOut.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
