package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.CreateUserManager;
import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    @FXML private Label CreateUserError;

    @FXML
    public void handleBackButton(MouseEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/Login-Screen.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)  ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Create Account");
            stage.setScene(new Scene(root));
            stage.show();

        } catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Back to login");
    }

    public void handleCreateUserButton(ActionEvent event){
        String username = enterUser.getText();
        String password = enterPassword.getText();
        String email = enterEmail.getText();
        // confirm password is not used at all

        //add error graphic if username exist
        if (!CreateUserManager.usernameExists(username)) {
            CreateUserManager.createUser(username, password, email);
            CreateUserError.setVisible(false);
            System.out.println("User " + username + " has been created");

            try{
                FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                        "/edu/utsa/cs3743/sakuraapplication/FXML/Login-Screen.fxml"));
                Parent root = fxmlLoader.load();

                Stage stage = (Stage)  ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Create Account");
                stage.setScene(new Scene(root));
                stage.show();

            } catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            CreateUserError.setVisible(true);
            System.out.println("User " + username + " has already been created");
        }
    }
}
