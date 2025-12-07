package edu.utsa.cs3743.sakuraapplication.Model;

public class MenuItem {
    private int itemId;
    private String name;
    private String calories;
    private double price;
//    private boolean available;

    public MenuItem() {}

    public MenuItem(String name, String calories, double price) {
//        this.itemId = itemId;
        this.name = name;
        this.calories = calories;
        this.price = price;
//        this.available = available;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories() {
        return calories;
    }

    public void setCategory(int category) {
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public boolean isAvailable() {
//        return available;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}