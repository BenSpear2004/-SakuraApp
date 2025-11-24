package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("SakuraDB");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void handleCreateUserButton(ActionEvent event){
        // handle errors
        // add user to database
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/Login-Screen.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("SakuraDB");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
