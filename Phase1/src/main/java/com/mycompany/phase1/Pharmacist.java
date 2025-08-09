package com.mycompany.phase1;

public class Pharmacist extends Person {
    private String licenseID;

    public Pharmacist(int id, String name, int phoneNum, String address, String licenseID) {
        super(id, name, phoneNum, address);
        this.licenseID = licenseID;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getLicenseID() {
        return licenseID;
    }

    public void setLicenseID(String licenseID) {
        this.licenseID = licenseID;
    }

    public void adjustStock(int medID, int newQty) {
        System.out.println("Stock updated for Medicine ID " + medID + ". New Quantity: " + newQty);
    }
}