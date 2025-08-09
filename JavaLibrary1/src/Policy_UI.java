// Policy UI
class Policy_UI {
    private PolicyController policyController;

    public Policy_UI(PolicyController policyController) {
        this.policyController = policyController;
    }

    public void displayPolicyInfo(int policyID) {
        Policy policy = policyController.getPolicy(policyID);
        if (policy != null) {
            System.out.println("Policy Information:");
            System.out.println("ID: " + policy.getPolicyID());
            System.out.println("Type: " + policy.getPolicyType());
            System.out.println("Coverage: " + policy.getCoverageDetails());
            System.out.println("Status: " + policy.getStatus());
            System.out.println("Premium: $" + policy.getPremiumAmount());
        } else {
            System.out.println("Policy not found.");
        }
    }

    public void showCoverageOptions() {
        System.out.println("Available Coverage Options:");
        System.out.println("1. Basic Coverage");
        System.out.println("2. Comprehensive Coverage");
        System.out.println("3. Premium Coverage");
    }
}

// Payment UI
class PaymentUI {
    private PaymentController paymentController;

    public PaymentUI(PaymentController paymentController) {
        this.paymentController = paymentController;
    }

    public void displayPaymentScreen(int clientID, int policyID, double amount) {
        System.out.println("Payment Screen");
        System.out.println("Policy ID: " + policyID);
        System.out.println("Amount Due: $" + amount);
    }

    public Payment collectPaymentDetails(int clientID, int policyID, double amount, 
                                       String paymentMethod, String description) {
        return paymentController.processPayment(clientID, policyID, amount, paymentMethod, description);
    }

    public void showReceipt(String receipt) {
        System.out.println(receipt);
    }
}