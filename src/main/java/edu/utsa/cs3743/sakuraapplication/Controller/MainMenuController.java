package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Manager.DataBaseManager;
import edu.utsa.cs3743.sakuraapplication.Manager.MenuItemManager;
import edu.utsa.cs3743.sakuraapplication.Model.MenuItem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;

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

}
