package edu.utsa.cs3743.sakuraapplication.Manager;

import edu.utsa.cs3743.sakuraapplication.Model.CartItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CheckOutManager {

    private final Connection connection;

    public CheckOutManager(Connection connection) {
        this.connection = connection;
    }

    public void checkout(int cookId, int tableNumber, String paymentMethod, BigDecimal tipAmount) throws SQLException {
        List<CartItem> cartItems = CartManager.getInstance().getCartItems();
        if (cartItems.isEmpty()) {
            throw new SQLException("Cart is empty.");
        }

        int orderId = createOrder(cookId, tableNumber, paymentMethod, tipAmount);
        BigDecimal totalAmount = insertOrderDetails(orderId, cartItems);
        updateOrderTotal(orderId, totalAmount);
    }

    private int createOrder(int cookId, int tableNumber, String paymentMethod, BigDecimal tipAmount) throws SQLException {
        String sql = "INSERT INTO orders (cook_id, table_number, order_time, total_amount, payment_method, tip_amount) " +
                "VALUES (?, ?, CURRENT_TIME(), 0, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, cookId);
            stmt.setInt(2, tableNumber);
            stmt.setString(3, paymentMethod);
            stmt.setBigDecimal(4, tipAmount);
            stmt.executeUpdate();

            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (!keys.next()) {
                    throw new SQLException("Failed to generate order ID.");
                }
                return keys.getInt(1);
            }
        }
    }

    private BigDecimal insertOrderDetails(int orderId, List<CartItem> cartItems) throws SQLException {
        String sql = "INSERT INTO order_details (menu_item_id, order_id, quantity, subtotal) VALUES (?, ?, ?, ?)";
        BigDecimal totalAmount = BigDecimal.ZERO;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (CartItem item : cartItems) {
                BigDecimal subtotal = BigDecimal.valueOf(item.getTotalPrice());
                totalAmount = totalAmount.add(subtotal);

                stmt.setInt(1, item.getMenuItem().getItemId());
                stmt.setInt(2, orderId);
                stmt.setInt(3, item.getQuantity());
                stmt.setBigDecimal(4, subtotal);
                stmt.addBatch();
            }
            stmt.executeBatch();
        }
        return totalAmount;
    }

    private void updateOrderTotal(int orderId, BigDecimal totalAmount) throws SQLException {
        String sql = "UPDATE orders SET total_amount = ? WHERE order_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBigDecimal(1, totalAmount);
            stmt.setInt(2, orderId);
            stmt.executeUpdate();
        }
    }
}
