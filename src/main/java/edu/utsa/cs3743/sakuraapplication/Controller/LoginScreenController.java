package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.LoginManager;
import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreenController {
    @FXML private TextField enterUser;

    @FXML private PasswordField enterPassword;

    @FXML private Label loginError;

    @FXML
    public void handleLoginButton(ActionEvent event){
        String username = enterUser.getText();
        String password = enterPassword.getText();

        boolean valid = LoginManager.authenticate(username, password);


        if (valid){
            System.out.println("Login successful for user: " + username);
            loginError.setVisible(false);

            // Only open Main Menu if login is valid
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                        "/edu/utsa/cs3743/sakuraapplication/FXML/MainMenu.fxml"));
                Parent root = fxmlLoader.load();

                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("SakuraDB");
                stage.setScene(new Scene(root));
                stage.setWidth(454);
                stage.setHeight(655);
                stage.show();

            } catch(IOException e) {
                e.printStackTrace();
            }

        } else {
            loginError.setVisible(true);
            System.out.println("Login failed for user: " + username);
        }
    }

    @FXML
    public void handleCreateUserButton(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/CreateUser.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage =  (Stage)  ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Create Account");
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
