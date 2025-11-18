package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController {
    @FXML private TextField enterUser;

    @FXML private PasswordField enterPassword;

    @FXML
    public void handleLoginButton(ActionEvent event){
        // check if user is already in database
        // if not throw error

        // TODO
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/MainMenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.setWidth(454);
            stage.setHeight(655);

            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCreateUserButton(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/CreateUser.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("Create Account");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
