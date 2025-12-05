package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.DataBaseManager;
import edu.utsa.cs3743.sakuraapplication.Manager.MenuItemManager;
import edu.utsa.cs3743.sakuraapplication.Model.MenuItem;
import edu.utsa.cs3743.sakuraapplication.SakuraDBApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import java.sql.Connection;

public class MainMenuController implements Initializable{

    @FXML
    private FlowPane menuFlow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadMenuCards();
    }

    private void loadMenuCards(){
        List<MenuItem> menuItems = MenuItemManager.getAllMenuItems();
        menuFlow.getChildren().clear();

        for(MenuItem item : menuItems) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/edu/utsa/cs3743/sakuraapplication/FXML/MenuItemCard.fxml"));
                AnchorPane card = loader.load();

                MenuItemCardController controller = loader.getController();
                controller.setData(item);

                menuFlow.getChildren().add(card);
            } catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void handleCartButton(ActionEvent event){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(SakuraDBApplication.class.getResource("/edu/utsa/cs3743/sakuraapplication/FXML/Cart.fxml"));
            Parent root = fxmlLoader.load();

            CartController controller = fxmlLoader.getController();
            controller.loadCartItems();

            Stage stage = (Stage)  ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Create Account");
            stage.setScene(new Scene(root, 500, 640));
            stage.show();

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
