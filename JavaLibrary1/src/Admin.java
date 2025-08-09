// Admin class
class Admin extends Person {
    private String adminLevel;

    public Admin(int personID, String name, String email, String phone, 
                String address, String username, String password, String adminLevel) {
        super(personID, name, email, phone, address, username, password);
        this.adminLevel = adminLevel;
    }

    public void approveClaim(int claimID, ClaimController claimController) {
        claimController.updateClaimStatus(claimID, "Approved");
    }

    public void rejectClaim(int claimID, ClaimController claimController) {
        claimController.updateClaimStatus(claimID, "Rejected");
    }

    public String generateReport(ClaimController claimController, PaymentController paymentController) {
        int totalClaims = claimController.getAllClaims().size();
        int approvedClaims = (int) claimController.getAllClaims().stream()
                                .filter(c -> c.getStatus().equals("Approved")).count();
        double totalPayments = paymentController.getAllPayments().stream()
                                .mapToDouble(Payment::getAmount).sum();

        return "Insurance System Report\n" +
               "Total Claims: " + totalClaims + "\n" +
               "Approved Claims: " + approvedClaims + "\n" +
               "Total Payments Received: $" + totalPayments;
    }

    // Getters
    public String getAdminLevel() { return adminLevel; }
}