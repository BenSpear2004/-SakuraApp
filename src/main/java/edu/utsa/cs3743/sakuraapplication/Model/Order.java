package edu.utsa.cs3743.sakuraapplication.Model;

import java.util.List;

public class Order {
    private int orderId;
    private int customerId;
    private int employeeId;
    private List<CartItem> cartItems;
    private double total;
    private String paymentMethod; // "cash" or "card"
    private String status;        // optional

    public Order() {}

    public Order(int orderId, int customerId, int employeeId,
                 List<CartItem> cartItems, double total,
                 String paymentMethod, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.cartItems = cartItems;
        this.total = total;
        this.paymentMethod = paymentMethod;
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order #" + orderId + " ($" + total + ")";
    }
}
