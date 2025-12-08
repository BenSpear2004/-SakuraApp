package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.LoginManager;
import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import edu.utsa.cs3743.sakuraapplication.Util.CurrentUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class LoginScreenController {

    @FXML private TextField enterUser;
    @FXML private PasswordField enterPassword;
    @FXML private Label loginError;

    @FXML
    public void handleLoginButton(ActionEvent event) {

        String username = enterUser.getText();
        String password = enterPassword.getText();

        ResultSet rs = LoginManager.authenticate(username, password);

        try {
            if (rs != null && rs.next()) {

                // ✅ STORE LOGGED-IN USER
                CurrentUser.setUser(
                        rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("email")
                );

                System.out.println("Logged in as: " + CurrentUser.getEmail());
                loginError.setVisible(false);

                // ✅ Load Main Menu
                FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                        "/edu/utsa/cs3743/sakuraapplication/FXML/MainMenu.fxml"));
                Parent root = fxmlLoader.load();

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("SakuraDB");
                stage.setScene(new Scene(root));
                stage.setWidth(970);
                stage.setHeight(700);
                stage.show();

            } else {
                loginError.setVisible(true);
                System.out.println("Login failed for user: " + username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCreateUserButton(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    SakuraDBApplication.class.getResource(
                            "/edu/utsa/cs3743/sakuraapplication/FXML/CreateUser.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Create Account");
            stage.setScene(new Scene(root));
            stage.setWidth(320);
            stage.setHeight(530);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
