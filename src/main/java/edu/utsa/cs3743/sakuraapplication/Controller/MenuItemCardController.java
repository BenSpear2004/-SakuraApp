package edu.utsa.cs3743.sakuraapplication.Controller;
import edu.utsa.cs3743.sakuraapplication.Model.MenuItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
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

        itemImage.setFitWidth(106);
        itemImage.setFitHeight(90);
        itemImage.setPreserveRatio(false);
        itemImage.setSmooth(true);

        Rectangle clip = new Rectangle(106, 87);
        clip.setArcWidth(20);   // Rounded corner horizontal radius
        clip.setArcHeight(20);  // Rounded corner vertical radius
        itemImage.setClip(clip);
    }


}
