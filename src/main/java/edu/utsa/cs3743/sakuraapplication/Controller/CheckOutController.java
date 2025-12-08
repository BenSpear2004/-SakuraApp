package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.DataBaseManager;
import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import edu.utsa.cs3743.sakuraapplication.Manager.CheckOutManager;
import edu.utsa.cs3743.sakuraapplication.Manager.CartManager;

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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.YearMonth;

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
    public void handlePayButton(ActionEvent event) {
        if (!validateCreditCard()) return;

        try (Connection conn = DataBaseManager.getConnection()) {
            performCheckout(conn);
            clearCart();
        } catch (SQLException e) {
            e.printStackTrace();
            errorLabel.setText("Error completing order.");
            return;
        }

        navigateToMainMenu(event);
    }


    private boolean validateCreditCard() {
        String card = cardText.getText();
        String date = dateText.getText();
        String csv = csvText.getText();

        if (card.isEmpty() || date.isEmpty() || csv.isEmpty()) {
            errorLabel.setText("Please enter all fields.");
            return false;
        }

        if (!card.matches("\\d{16}")) {
            errorLabel.setText("Invalid credit card number.");
            return false;
        }

        if (!date.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
            errorLabel.setText("Invalid expiration date.");
            return false;
        }

        String[] part = date.split("/");
        int month = Integer.parseInt(part[0]);
        int year = Integer.parseInt(part[1]) + 2000;

        if (YearMonth.of(year, month).isBefore(YearMonth.now())) {
            errorLabel.setText("Card is expired.");
            return false;
        }

        if (!csv.matches("\\d{3}")) {
            errorLabel.setText("Invalid CSV number.");
            return false;
        }

        return true;
    }

    private void performCheckout(Connection conn) throws SQLException {
        CheckOutManager checkoutManager = new CheckOutManager(conn);

        int cookId = 1;
        int tableNumber = 1;
        String paymentMethod = "card";
        BigDecimal tipAmount = BigDecimal.ZERO;

        checkoutManager.checkout(cookId, tableNumber, paymentMethod, tipAmount);
    }

    private void clearCart() {
        CartManager.getInstance().getCartItems().clear();
    }

    private void navigateToMainMenu(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource(
                    "/edu/utsa/cs3743/sakuraapplication/FXML/MainMenu.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("SakuraDB");
            stage.setScene(new Scene(root, 970, 700));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            errorLabel.setText("Error loading main menu.");
        }
    }
}
