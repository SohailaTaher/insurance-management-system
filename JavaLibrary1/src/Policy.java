
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Policy class
class Policy {
    private int policyID;
    private String policyType;
    private String coverageDetails;
    private Date startDate;
    private Date endDate;
    private String status;
    private double premiumAmount;

    public Policy(int policyID, String policyType, String coverageDetails, 
                 Date startDate, Date endDate, double premiumAmount) {
        this.policyID = policyID;
        this.policyType = policyType;
        this.coverageDetails = coverageDetails;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Active";
        this.premiumAmount = premiumAmount;
    }

    public void modifyCoverage(String newCoverageDetails) {
        this.coverageDetails = newCoverageDetails;
    }

    public void renewPolicy(Date newEndDate) {
        this.endDate = newEndDate;
        this.status = "Active";
    }

    public void cancelPolicy() {
        this.status = "Cancelled";
    }

    // Getters
    public int getPolicyID() { return policyID; }
    public String getPolicyType() { return policyType; }
    public String getCoverageDetails() { return coverageDetails; }
    public Date getStartDate() { return startDate; }
    public Date getEndDate() { return endDate; }
    public String getStatus() { return status; }
    public double getPremiumAmount() { return premiumAmount; }
}

// Policy Controller
class PolicyController {
    private Map<Integer, Policy> policies;

    public PolicyController() {
        this.policies = new HashMap<>();
    }

    public void addPolicy(Policy policy) {
        policies.put(policy.getPolicyID(), policy);
    }

    public Policy getPolicy(int policyID) {
        return policies.get(policyID);
    }

    public List<Policy> getAllPolicies() {
        return new ArrayList<>(policies.values());
    }

    public void modifyPolicyCoverage(int policyID, String newCoverage) {
        Policy policy = policies.get(policyID);
        if (policy != null) {
            policy.modifyCoverage(newCoverage);
        }
    }
}