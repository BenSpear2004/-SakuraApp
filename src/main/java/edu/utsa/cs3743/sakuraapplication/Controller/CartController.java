package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.CartManager;
import edu.utsa.cs3743.sakuraapplication.Model.CartItem;
import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CartController {

    @FXML
    private VBox cartContainer;

    @FXML
    private Label priceLabel;

    @FXML
    public void handleHomeButton(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/MainMenu.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)  ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Main Menu");
            stage.setScene(new Scene(root));
            stage.setWidth(970);
            stage.setHeight(700);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleCheckoutButton(ActionEvent event){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/CheckOut.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage = (Stage)  ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Checkout Screen");
            stage.setScene(new Scene(root));
            stage.setWidth(450);
            stage.setHeight(600);
            stage.show();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadCartItems() {
        cartContainer.getChildren().clear();

        for (CartItem cartItem : CartManager.getInstance().getCartItems()){
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/utsa/cs3743/sakuraapplication/FXML/CheckOutCard.fxml"));
                Parent card = loader.load();

                CartItemCardController controller = loader.getController();
                controller.setData(cartItem);


                controller.setOnRemoveCallback(() -> {
                    CartManager.getInstance().removeItem(cartItem);
                    cartContainer.getChildren().remove(card);
                    priceLabel.setText("$" + CartManager.getInstance().getTotalPrice());
                });

                cartContainer.getChildren().add(card);
            } catch(IOException e){
                e.printStackTrace();
            }
        }

        priceLabel.textProperty().set("$" + CartManager.getInstance().getTotalPrice());
    }
}
