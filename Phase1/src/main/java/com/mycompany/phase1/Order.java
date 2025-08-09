package com.mycompany.phase1;
import java.util.List;

public class Order {
    private int orderID;
    private int clientID;
    private List<Medicine> medicineList;
    private String status;

    public Order(int orderID, int clientID, List<Medicine> medicineList, String status) {
        this.orderID = orderID;
        this.clientID = clientID;
        this.medicineList = medicineList;
        this.status = status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double calculateTotalPrice() {
        double total = 0;
        for (Medicine med : medicineList) {
            total += med.getPrice();
        }
        return total;
    }
}
