package com.mycompany.phase1;

public class Supplier {
    private int supplierID;
    private String companyName;

    public Supplier(int supplierID, String companyName) {
        this.supplierID = supplierID;
        this.companyName = companyName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void supplyMedicine(int medID, int quantity) {
        System.out.println("Supplied Medicine ID " + medID + " with Quantity: " + quantity);
    }
}