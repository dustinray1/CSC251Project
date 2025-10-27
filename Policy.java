public class Policy {

    // Variables
    private String policyNumber;
    private String providerName;
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private double policyholderHeightInches;
    private double policyholderWeightPounds;

    /**
     * No-arg constructor to initialize the Policy with default values.
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyholderFirstName = "";
        this.policyholderLastName = "";
        this.policyholderAge = 0;
        this.policyholderSmokingStatus = "non-smoker";
        this.policyholderHeightInches = 0.0;
        this.policyholderWeightPounds = 0.0;
    }

    /**
     * Full constructor to initialize the Policy with given values.
     *
     * @param policyNumber             the policy number
     * @param providerName             the name of the policy provider
     * @param policyholderFirstName    the first name of the policyholder
     * @param policyholderLastName     the last name of the policyholder
     * @param policyholderAge          the age of the policyholder
     * @param policyholderSmokingStatus the smoking status of the policyholder
     * @param policyholderHeightInches the height of the policyholder in inches
     * @param policyholderWeightPounds the weight of the policyholder in pounds
     */
    public Policy(String policyNumber,
                  String providerName,
                  String policyholderFirstName,
                  String policyholderLastName,
                  int policyholderAge,
                  String policyholderSmokingStatus,
                  double policyholderHeightInches,
                  double policyholderWeightPounds) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        setPolicyholderSmokingStatus(policyholderSmokingStatus);
        this.policyholderHeightInches = policyholderHeightInches;
        this.policyholderWeightPounds = policyholderWeightPounds;
    }

    /**
     * Gets the policy number.
     *
     * @return the policy number
     */
    public String getPolicyNumber() { return policyNumber; }

    // Repeat similar Javadoc comments for the other getters and setters...

    /**
     * Sets the smoking status for this Policyholder.
     *
     * @param status the smoking status to set, either "smoker" or "non-smoker"
     */
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

    /**
     * Calculates the BMI (Body Mass Index) of the policyholder.
     *
     * @return the BMI value
     */
    public double getBMI() {
        if (policyholderHeightInches <= 0) {
            return 0.0;
        }
        return (policyholderWeightPounds * 703.0) /
                (policyholderHeightInches * policyholderHeightInches);
    }

    /**
     * Calculates the price of the policy based on age, smoking status, and BMI.
     *
     * @return the calculated price of the policy
     */
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
