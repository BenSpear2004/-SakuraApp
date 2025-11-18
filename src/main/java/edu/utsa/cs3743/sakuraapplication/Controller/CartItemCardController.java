package edu.utsa.cs3743.sakuraapplication.Controller;

import edu.utsa.cs3743.sakuraapplication.Model.CartItem;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class CartItemCardController {
    @FXML
    private ImageView foodImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label quantityLabel;

    private CartItem cartItem;

    public void setData(CartItem cartItem){
        this .cartItem = cartItem;

        nameLabel.setText(cartItem.getMenuItem().getName());
        quantityLabel.setText(String.valueOf(cartItem.getQuantity()));

        String fileName = cartItem.getMenuItem().getName()
                .trim()
                .toLowerCase()
                .replace(" ","_" )
                .replace("-", "_")
                .replace("/", "_")
                + ".png";
        try{
            Image img = new Image(getClass().getResourceAsStream("/edu/utsa/cs3743/sakuraapplication/Images/" + fileName));
            foodImage.setImage(img);
        } catch (Exception e){
            System.out.println("Image missing: " + fileName);
        }

        foodImage.setFitWidth(70);
        foodImage.setFitHeight(57);
        foodImage.setPreserveRatio(false);
        foodImage.setSmooth(true);

        Rectangle clip = new Rectangle(70, 57);   // size you want all displayed images
        clip.setArcWidth(18);      // rounding amount (0 for square corners)
        clip.setArcHeight(18);     // rounding amount
        foodImage.setClip(clip);

    }
}
