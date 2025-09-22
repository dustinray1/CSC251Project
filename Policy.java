public class Policy {

    // variables
    private String policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private int policyholderHeightInches;
    private int policyholderWeightPounds;

    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyholderFirstName = "";
        this.policyholderLastName = "";
        this.policyholderAge = 0;
        this.policyholderSmokingStatus = "non-smoker";
        this.policyholderHeightInches = 0;
        this.policyholderWeightPounds = 0;
    }

    public Policy(String policyNumber,
                  String providerName,
                  String policyholderFirstName,
                  String policyholderLastName,
                  int policyholderAge,
                  String policyholderSmokingStatus,
                  int policyholderHeightInches,
                  int policyholderWeightPounds) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        setPolicyholderSmokingStatus(policyholderSmokingStatus);
        this.policyholderHeightInches = policyholderHeightInches;
        this.policyholderWeightPounds = policyholderWeightPounds;
    }
    // getters
    public String getPolicyNumber() { return policyNumber; }
    public String getProviderName() { return providerName; }
    public String getPolicyholderFirstName() { return policyholderFirstName; }
    public String getPolicyholderLastName() { return policyholderLastName; }
    public int getPolicyholderAge() { return policyholderAge; }
    public String getPolicyholderSmokingStatus() { return policyholderSmokingStatus; }
    public int getPolicyholderHeightInches() { return policyholderHeightInches; }
    public int getPolicyholderWeightPounds() { return policyholderWeightPounds; }
    // setters
    public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
    public void setProviderName(String providerName) { this.providerName = providerName; }
    public void setPolicyholderFirstName(String firstName) { this.policyholderFirstName = firstName; }
    public void setPolicyholderLastName(String lastName) { this.policyholderLastName = lastName; }
    public void setPolicyholderAge(int age) { this.policyholderAge = age; }

    public void setPolicyholderSmokingStatus(String status) {
        if (status == null) {
            this.policyholderSmokingStatus = "non-smoker";
        } else {
            String smoke = status.trim().toLowerCase();
            if (smoke.equals("smoker")) {
                this.policyholderSmokingStatus = "smoker";
            } else {
                this.policyholderSmokingStatus = "non-smoker";
            }
        }
    }

    public void setPolicyholderHeightInches(int heightInches) { this.policyholderHeightInches = heightInches; }
    public void setPolicyholderWeightPounds(int weightPounds) { this.policyholderWeightPounds = weightPounds; }

    public double getBMI() {
        if (policyholderHeightInches <= 0) {
            return 0.0;
        }
        return (policyholderWeightPounds * 703.0) /
                (policyholderHeightInches * policyholderHeightInches);
    }

    public double calculatePrice() {
        double price = 600.0;
        if (policyholderAge > 50) {
            price += 75.0;
        }
        if (policyholderSmokingStatus.equals("smoker")) {
            price += 100.0;
        }
        double bmi = getBMI();
        if (bmi > 35.0) {
            double additionalFee = (bmi - 35.0) * 20.0;
            price += additionalFee;
        }
        return price;
    }
}
