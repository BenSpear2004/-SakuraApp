package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.DataBaseManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;

public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public static void main(String[] args){

        Connection conn = DataBaseManager.getConnection();
        System.out.println(conn != null ? "Connected!" : "Failed to connect.");
    }
}
