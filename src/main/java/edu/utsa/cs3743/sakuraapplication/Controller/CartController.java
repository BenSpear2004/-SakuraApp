package edu.utsa.cs3743.sakuraapplication.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class CartController {

    @FXML
    public void handleHomeButton(ActionEvent event){
        // send user back to main menu
        System.out.println("Back to main menu");
    }

    @FXML
    public void handleCheckoutButton(ActionEvent event){
        // send user to check out screen
        System.out.println("Checkout");
    }
}
