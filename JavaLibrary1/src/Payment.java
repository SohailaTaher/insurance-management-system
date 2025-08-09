
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Payment class
class Payment {
    private String paymentID;
    private int clientID;
    private double amount;
    private Date paymentDate;
    private String receipt;
    private String paymentMethod;
    private String description;
    
    public static List<Payment> AllPayments = new ArrayList<>();

    public Payment(String paymentID, int clientID, double amount, 
                  String paymentMethod, String description) {
        this.paymentID = paymentID;
        this.clientID = clientID;
        this.amount = amount;
        this.paymentDate = new Date();
        this.paymentMethod = paymentMethod;
        this.description = description;
        generateReceipt();
        AllPayments.add(this);
    }

    private void generateReceipt() {
        this.receipt = "Payment Receipt\n" +
                      "ID: " + paymentID + "\n" +
                      "Date: " + paymentDate + "\n" +
                      "Amount: $" + amount + "\n" +
                      "Method: " + paymentMethod + "\n" +
                      "Description: " + description;
    }

    // Getters
    public String getPaymentID() { return paymentID; }
    public int getClientID() { return clientID; }
    public double getAmount() { return amount; }
    public Date getPaymentDate() { return paymentDate; }
    public String getReceipt() { return receipt; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getDescription() { return description; }
}

// Payment Controller
class PaymentController {
    private Map<String, Payment> payments;
    private PolicyController policyController;

    public PaymentController(PolicyController policyController) {
        this.payments = new HashMap<>();
        this.policyController = policyController;
    }

    public Payment processPayment(int clientID, int policyID, double amount, 
                                String paymentMethod, String description) {
        Policy policy = policyController.getPolicy(policyID);
        if (policy == null || policy.getStatus().equals("Cancelled")) {
            return null;
        }

        String paymentID = "PAY-" + System.currentTimeMillis();
        Payment payment = new Payment(paymentID, clientID, amount, paymentMethod, description);
        payments.put(paymentID, payment);
        return payment;
    }

    public List<Payment> getPaymentHistory(int clientID) {
        List<Payment> clientPayments = new ArrayList<>();
        for (Payment payment : payments.values()) {
            if (payment.getClientID() == clientID) {
                clientPayments.add(payment);
            }
        }
        return clientPayments;
    }

    public String generateInvoice(Payment payment) {
        return "Invoice\n" +
               "Payment ID: " + payment.getPaymentID() + "\n" +
               "Date: " + payment.getPaymentDate() + "\n" +
               "Amount: $" + payment.getAmount() + "\n" +
               "Payment Method: " + payment.getPaymentMethod() + "\n" +
               "Description: " + payment.getDescription();
    }

    public List<Payment> getAllPayments() {
        return Payment.AllPayments;
    }
}