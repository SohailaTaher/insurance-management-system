
import java.util.ArrayList;
import java.util.List;

// Client class
class Client extends Person {
    private List<Integer> policyList;
    private List<Integer> claimList;

    public Client(int personID, String name, String email, String phone, 
                 String address, String username, String password) {
        super(personID, name, email, phone, address, username, password);
        this.policyList = new ArrayList<>();
        this.claimList = new ArrayList<>();
    }

    public void addPolicy(int policyID) {
        policyList.add(policyID);
    }

    public void addClaim(int claimID) {
        claimList.add(claimID);
    }

    // Getters
    public List<Integer> getPolicyList() { return policyList; }
    public List<Integer> getClaimList() { return claimList; }
}

