package edu.utsa.cs3743.sakuraapplication.Controller;
import edu.utsa.cs3743.sakuraapplication.Model.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.Locale;

public class MenuItemCardController {

    @FXML
    private Label caloriesLabel;

    @FXML
    private AnchorPane cardRoot;

    @FXML
    private ImageView itemImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    public void setData(MenuItem item){
        nameLabel.setText(item.getName());
        priceLabel.setText("$" + String.format("%.2f", item.getPrice()));
        caloriesLabel.setText(item.getCalories() + " calories");

        String fileName = item.getName()
                .trim()
                .toLowerCase()
                .replace(" ","_" )
                .replace("-", "_")
                .replace("/", "_")
                + ".png";
        try{
            Image img = new Image(getClass().getResourceAsStream("/edu/utsa/cs3743/sakuraapplication/Images/" + fileName));
            itemImage.setImage(img);
        } catch (Exception e){
            System.out.println("Image missing: " + fileName);
        }
    }


}
