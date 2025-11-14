package edu.utsa.cs3743.sakuraapplication.Model;

public class Payment {
    private int paymentId;
    private int orderId;
    private String method; // "cash" or "card"
    private double amount;

    public Payment() {}

    public Payment(int paymentId, int orderId, String method, double amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.method = method;
        this.amount = amount;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Paid " + amount + " via " + method;
    }
}
