package edu.utsa.cs3743.sakuraapplication.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginScreenController {
    @FXML private TextField enterUser;

    @FXML private PasswordField enterPassword;

    @FXML
    public void handleLoginButton(ActionEvent event){
        System.out.println("Login");
    }

    @FXML
    public void handleCreateUserButton(ActionEvent event){
        System.out.println("Create new User");
    }
}
