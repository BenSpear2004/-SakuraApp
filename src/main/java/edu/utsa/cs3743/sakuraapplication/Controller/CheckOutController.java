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
            errorLabel.setText("Please enter all fields.");
            return;
        }

        if(!card.matches("\\d{16}")){
            errorLabel.setText("Invalid credit card number.");
            return;
        }

        if(!date.matches("^(0[1-9]|1[0-2])/\\d{2}$")){
            errorLabel.setText("Invalid expiration date.");
            return;
        }

        String[] part = date.split("/");
        int month = Integer.parseInt(part[0]);
        int year = Integer.parseInt(part[1]);

        if(month < 12 && year < 25){
            errorLabel.setText("Invalid expiration date.");
            return;
        }

        if(!csv.matches("\\d{3}")){
            errorLabel.setText("Invalid csv number.");
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
