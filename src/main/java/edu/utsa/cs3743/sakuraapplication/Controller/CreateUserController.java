package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.CreateUserManager;
import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

import static edu.utsa.cs3743.sakuraapplication.Manager.CreateUserManager.confirmPassword;

public class CreateUserController {

    @FXML private TextField enterUser;
    @FXML private PasswordField enterPassword;
    @FXML private PasswordField confirmPassword;
    @FXML private TextField enterEmail;
    @FXML private Label CreateUserError;
    @FXML private Label PasswordDoNotMatch;

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
        String username = enterUser.getText();
        String password = enterPassword.getText();
        String confirm = confirmPassword.getText();
        String email = enterEmail.getText();
        // confirm password is not used at all


        if (!CreateUserManager.usernameExists(username) && CreateUserManager.confirmPassword(password, confirm)) {
            CreateUserManager.createUser(username, password, email);
            CreateUserError.setVisible(false);
            System.out.println("User " + username + " has been created");

            try{
                FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                        "/edu/utsa/cs3743/sakuraapplication/FXML/Login-Screen.fxml"));
                Scene scene = new Scene(fxmlLoader.load());

                Stage stage = new Stage();
                stage.setTitle("Create Account");
                stage.setScene(scene);
                stage.show();

            } catch(IOException e){
                e.printStackTrace();
            }
        }
        else if(CreateUserManager.usernameExists(username)) {
            CreateUserError.setVisible(true);
            PasswordDoNotMatch.setVisible(false);
            System.out.println("User " + username + " has already been created");
        }
        else if(!CreateUserManager.confirmPassword(password, confirm)) {
            PasswordDoNotMatch.setVisible(true);
            CreateUserError.setVisible(false);
            System.out.println("Passwords do not match");
        }
    }
}
