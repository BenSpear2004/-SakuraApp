package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

import static edu.utsa.cs3743.sakuraapplication.Util.CurrentUser.*;

public class ProfileController {

    @FXML
    private Button CartBTN;

    @FXML
    private Label EmailLabel;

    @FXML
    private Button MainMenuBTN;

    @FXML
    private Button SignOutBtn;

    @FXML
    private Label UsernameLabel;

    public void initialize(){
        UsernameLabel.setText(getUsername());
        EmailLabel.setText(getEmail());
    }

    @FXML
    public void handleSignOutBtn(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                    "/edu/utsa/cs3743/sakuraapplication/FXML/Login-Screen.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("SakuraDB");
            stage.setScene(new Scene(root));
            stage.setWidth(350);
            stage.setHeight(500);
            stage.show();
        }catch(Exception e){
            System.out.println("File Not Found");
        }
    }

    @FXML
    public void handleMainMenuBTN(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                    "/edu/utsa/cs3743/sakuraapplication/FXML/MainMenu.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("SakuraDB");
            stage.setScene(new Scene(root));
            stage.setWidth(970);
            stage.setHeight(700);
            stage.show();
        }catch(Exception e){
            System.out.println("File Not Found");
        }
    }

    @FXML
    public void handleCartBTN(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                    "/edu/utsa/cs3743/sakuraapplication/FXML/Cart.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("SakuraDB");
            stage.setScene(new Scene(root));
            stage.setWidth(520);
            stage.setHeight(650);
            stage.show();
        }catch(Exception e){
            System.out.println("File Not Found");
        }
    }
}
