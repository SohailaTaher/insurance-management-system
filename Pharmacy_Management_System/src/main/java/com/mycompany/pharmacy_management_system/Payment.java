

public class Payment {
  private int paymentID;
 private double amount;
  private String paymentMethod;
   private String paymentDate;

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }
 public Payment(int paymentID, double amount, String paymentMethod,String paymentDate ) {
        this.paymentID = paymentID;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public boolean proccessPayment(){
      if (amount <= 0) {
            System.out.println("Invalid payment amount. Payment failed.");
            return false;
        }

        if (paymentMethod.isEmpty()) {
            System.out.println("Invalid payment method. Payment failed.");
            return false;
        }
        System.out.println("Payment of " + amount + " via " + paymentMethod + " on " + paymentDate + " processed successfully.");
        return true;
    
    }

   
}