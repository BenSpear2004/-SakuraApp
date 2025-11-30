package edu.utsa.cs3743.sakuraapplication.Manager;

import edu.utsa.cs3743.sakuraapplication.Model.CartItem;
import edu.utsa.cs3743.sakuraapplication.Model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static final CartManager instance = new CartManager();
    private final List<CartItem> cartItems = new ArrayList<>();


    private CartManager() {}


    public static CartManager getInstance(){
        return instance;
    }

    public void addItem(MenuItem menuItem) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getMenuItem().getName().equals(menuItem.getName())) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                return;
            }
        }
        cartItems.add(new CartItem(menuItem, 1));
    }

    public List<CartItem> getCartItems() {
            return cartItems;
    }

    public double getTotalPrice() {
        return cartItems.stream()
                .mapToDouble(cartItem -> cartItem.getTotalPrice())
                .sum();
    }
}
