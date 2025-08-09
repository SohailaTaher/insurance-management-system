
import java.util.*;

// Insurance System
public class Insurance_System {
    private PolicyController policyController;
    private ClaimController claimController;
    private PaymentController paymentController;
    private FeedbackController feedbackController;
    private Map<Integer, Client> clients;
    private Map<Integer, Admin> admins;

    public Insurance_System() {
        this.policyController = new PolicyController();
        this.claimController = new ClaimController(policyController);
        this.paymentController = new PaymentController(policyController);
        this.feedbackController = new FeedbackController();
        this.clients = (Map<Integer, Client>) new HashMap();
        this.admins = (Map<Integer, Admin>) new HashMap();

        // Initialize with sample data
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample admin
        Admin admin = new Admin(1, "Admin User", "admin@insurance.com", "1234567890", 
                              "123 Admin St", "admin", "admin123", "Super");
        admins.put(1, admin);

        // Add sample client
        Client client = new Client(101, "John Doe", "john@example.com", "5551234567", 
                                "123 Main St", "johndoe", "password123");
        clients.put(101, client);

        // Add sample policy
        Policy policy = new Policy(1001, "Auto Insurance", "Comprehensive coverage for vehicles", 
                                 new Date(), new Date(System.currentTimeMillis() + 31536000000L), // 1 year later
                                 1200.00);
        policyController.addPolicy(policy);
        client.addPolicy(1001);
    }

    // Client operations
    public Client registerClient(String name, String email, String phone, String address, 
                               String username, String password) {
        int clientID = clients.size() + 100;
        Client client = new Client(clientID, name, email, phone, address, username, password);
        clients.put(clientID, client);
        return client;
    }

    public Claim submitClaim(int clientID, int policyID, String description, double claimAmount) {
        Client client = clients.get(clientID);
        if (client == null) return null;

        Claim claim = claimController.submitClaim(policyID, description, claimAmount);
        if (claim != null) {
            client.addClaim(claim.getClaimID());
        }
        return claim;
    }

    // Admin operations
    public Admin registerAdmin(String name, String email, String phone, String address, 
                             String username, String password, String adminLevel) {
        int adminID = admins.size() + 1;
        Admin admin = new Admin(adminID, name, email, phone, address, username, password, adminLevel);
        admins.put(adminID, admin);
        return admin;
    }

    // Getters for controllers
    public PolicyController getPolicyController() { return policyController; }
    public ClaimController getClaimController() { return claimController; }
    public PaymentController getPaymentController() { return paymentController; }
    public FeedbackController getFeedbackController() { return feedbackController; }
    public Map<Integer, Client> getClients() { return clients; }
    public Map<Integer, Admin> getAdmins() { return admins; }

    public static void main(String[] args) {
        Insurance_System system = new Insurance_System();
        
        // Example usage
        Policy_UI policyUI = new Policy_UI(system.getPolicyController());
        policyUI.displayPolicyInfo(1001);
        
        PaymentUI paymentUI = new PaymentUI(system.getPaymentController());
        Payment payment = paymentUI.collectPaymentDetails(101, 1001, 1200.00, "Credit Card", "Annual Premium");
        if (payment != null) {
            paymentUI.showReceipt(payment.getReceipt());
        }
    }
}