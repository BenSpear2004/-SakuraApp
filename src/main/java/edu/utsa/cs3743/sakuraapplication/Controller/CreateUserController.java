package edu.utsa.cs3743.sakuraapplication.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CreateUserController {

    @FXML private TextField enterUser;

    @FXML private PasswordField enterPassword;

    @FXML private PasswordField confirmPassword;

    @FXML private TextField enterEmail;

    @FXML
    public void handleBackButton(MouseEvent event){
        // take user back to login screen
        System.out.println("Back to login");
    }

    public void handleCreateUserButton(ActionEvent event){
        // handle errors
        // add user to database
        // take user back to login page
        System.out.println("created user");
    }
}
