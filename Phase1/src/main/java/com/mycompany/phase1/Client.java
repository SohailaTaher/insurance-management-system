package com.mycompany.phase1;


import java.util.List;

public class Client extends Person {
    private List<Order> orderHistory;

    public Client(int id, String name, int phoneNum, String address, List<Order> orderHistory) {
        super(id, name, phoneNum, address);
        this.orderHistory = orderHistory;
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
    
    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public void orderMedicine(Medicine med) {
        System.out.println("Medicine Ordered: " + med.getName());
    }

    public void cancelOrder(int orderID) {
        System.out.println("Order " + orderID + " has been canceled.");
    }

    public List<Order> viewOrders() {
        return orderHistory;
    }

    public void createAcc() {
        System.out.println("Account Created.");
    }

    public void manageAcc() {
        System.out.println("Account Managed.");
    }

    public void updateOrder(int orderID) {
        System.out.println("Order " + orderID + " updated.");
    }
}