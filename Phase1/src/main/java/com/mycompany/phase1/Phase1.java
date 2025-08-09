package com.mycompany.phase1;
import java.util.ArrayList;
import java.util.List;

public class Phase1 {
    public static void main(String[] args) {
        // Create Medicines
        Medicine med1 = new Medicine(101, "Paracetamol", 50.0, 10, "2025-12-31");
        Medicine med2 = new Medicine(102, "Ibuprofen", 75.0, 5, "2026-06-30");

        // Create a List of Medicines for Order
        List<Medicine> medicines = new ArrayList<>();
        medicines.add(med1);
        medicines.add(med2);

        // Create Client
        Client client = new Client(1, "Sou", 123456789, "Cairo", new ArrayList<>());

        // Client Orders Medicine
        client.orderMedicine(med1);
        
        // Create an Order
        Order order = new Order(5001, client.id, medicines, "Pending");
        System.out.println("Order Created! Total Price: " + order.calculateTotalPrice());

        // Add Order to Client's History
        client.viewOrders().add(order);

        // Create Payment
        Payment payment = new Payment(9001, order.calculateTotalPrice(), "Credit Card", "2025-03-24");

        // Process Payment
        boolean paymentStatus = payment.processPayment();
        if (paymentStatus) {
            order.setStatus("Completed");
            System.out.println("Order " + order.getOrderID() + " is now " + order.getStatus());
        }

        // Create Admin
        Admin admin = new Admin(2, "Admin1", 987654321, "Giza", "admin123", "pass123");
        admin.addMedicine(med1);
        admin.removeMedicine(102);

        // Create Pharmacist
        Pharmacist pharmacist = new Pharmacist(3, "Dr. Nada", 456123789, "Alexandria", "PHARMA123");
        pharmacist.adjustStock(101, 20);

        // Create Supplier
        Supplier supplier = new Supplier(501, "MediSupply Co.");
        supplier.supplyMedicine(101, 50);
        
        System.out.println("Pharmacy Management System Test Completed Successfully! 🎉");
    }
}