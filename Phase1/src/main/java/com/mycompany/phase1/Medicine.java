package com.mycompany.phase1;

public class Medicine {
    private int medID;
    private String name;
    private double price;
    private int quantity;
    private String expDate;

    public Medicine(int medID, String name, double price, int quantity, String expDate) {
        this.medID = medID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.expDate = expDate;
    }

    public int getMedID() {
        return medID;
    }

    public void setMedID(int medID) {
        this.medID = medID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

   

    public void updateQuantity(int newQty) {
        this.quantity = newQty;
        System.out.println("Quantity updated to: " + newQty);
    }

    public boolean isExpired(String expDate) {
        // Simplified check for expiration
        return this.expDate.compareTo(expDate) < 0;
    }
}
