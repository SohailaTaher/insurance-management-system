package com.mycompany.phase1;

public class Admin extends Person {
    private String username;
    private String password;

    public Admin(int id, String name, int phoneNum, String address, String username, String password) {
        super(id, name, phoneNum, address);
        this.username = username;
        this.password = password;
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
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addMedicine(Medicine med) {
        System.out.println("Medicine added: " + med.getName());
    }

    public void removeMedicine(int medID) {
        System.out.println("Medicine with ID " + medID + " removed.");
    }

    public void updateMedicine(int medID, Medicine newData) {
        System.out.println("Medicine with ID " + medID + " updated.");
    }

    public String generateReport() {
        return "Report generated.";
    }
}
