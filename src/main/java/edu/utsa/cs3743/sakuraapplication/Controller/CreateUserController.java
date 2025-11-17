package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateUserController {

    @FXML private TextField enterUser;

    @FXML private PasswordField enterPassword;

    @FXML private PasswordField confirmPassword;

    @FXML private TextField enterEmail;

    @FXML
    public void handleBackButton(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/Login-Screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("Create Account");
            stage.setScene(scene);
            stage.show();

        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Back to login");
    }

    public void handleCreateUserButton(ActionEvent event){
        // handle errors
        // add user to database
        // take user back to login page
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/Login-Screen.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            Stage stage = new Stage();
            stage.setTitle("Create Account");
            stage.setScene(scene);
            stage.show();

        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("created user");
    }
}
