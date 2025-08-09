
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.text.Document;

// Claim class
class Claim {
    private int claimID;
    private int policyID;
    private Date dateFiled;
    private String status;
    private String description;
    private double claimAmount;
    
    public static List <Claim> AllClaims = new ArrayList<>();
    
    public Claim(int claimID, int policyID, String description, double claimAmount) {
        this.claimID = claimID;
        this.policyID = policyID;
        this.dateFiled = new Date();
        this.status = "Submitted";
        this.description = description;
        this.claimAmount = claimAmount;
        AllClaims.add(this);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public String trackStatus() {
        return this.status;
    }

    // Getters
    public int getClaimID() { return claimID; }
    public int getPolicyID() { return policyID; }
    public Date getDateFiled() { return dateFiled; }
    public String getStatus() { return status; }
    public String getDescription() { return description; }
    public double getClaimAmount() { return claimAmount; }
}

// Claim Controller
class ClaimController {
    private Map<Integer, Claim> claims;
    private PolicyController policyController;
    
    
    
    public ClaimController(PolicyController policyController) {
        this.claims = new HashMap<>();
        this.policyController = policyController;
    }

    public Claim submitClaim(int policyID, String description, double claimAmount) {
        Policy policy = policyController.getPolicy(policyID);
        if (policy == null || !policy.getStatus().equals("Active")) {
            return null;
        }

        int claimID = claims.size() + 1;
        Claim claim = new Claim(claimID, policyID, description, claimAmount);
        claims.put(claimID, claim);
        return claim;
    }

    public Claim getClaim(int claimID) {
        return claims.get(claimID);
    }

    public List<Claim> getClaimsForPolicy(int policyID) {
        List<Claim> policyClaims = new ArrayList<>();
        for (Claim claim : claims.values()) {
            if (claim.getPolicyID() == policyID) {
                policyClaims.add(claim);
            }
        }
        return policyClaims;
    }

    public void updateClaimStatus(int claimID, String newStatus) {
        Claim claim = claims.get(claimID);
        if (claim != null) {
            claim.updateStatus(newStatus);
        }
    }

    public List<Claim> getAllClaims() {
     return Claim.AllClaims;

}


}