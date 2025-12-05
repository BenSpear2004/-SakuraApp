package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckOutController {
    @FXML
    private TextField cardText;

    @FXML
    private TextField dateText;

    @FXML
    private TextField csvText;

    @FXML
    private Label errorLabel;

    @FXML
    public void handlePayButton(ActionEvent event){
        String card = cardText.getText();
        String date = dateText.getText();
        String csv = csvText.getText();

        if(card.isEmpty() || date.isEmpty() || csv.isEmpty()){
            return;
        }

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
    }
}
