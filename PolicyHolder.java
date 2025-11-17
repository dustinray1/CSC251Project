public class PolicyHolder {

    // Variable Fields
    private String policyholderFirstName;
    private String policyholderLastName;
    private int policyholderAge;
    private String policyholderSmokingStatus;
    private double policyholderHeightInches;
    private double policyholderWeightPounds;


    /**
     * Default constructor 
     */
    public PolicyHolder() {
        this.policyholderFirstName = "";
        this.policyholderLastName = "";
        this.policyholderAge = 0;
        this.policyholderSmokingStatus = "non-smoker";
        this.policyholderHeightInches = 0.0;
        this.policyholderWeightPounds = 0.0;
    }


     /**
     * Full constructor to initialize the PolicyHolder with given values.
     *
     * @param policyholderFirstName   the first name of the policyholder
     * @param policyholderLastName    the last name of the policyholder
     * @param policyholderAge         the age of the policyholder
     * @param policyholderSmokingStatus the smoking status of the policyholder (e.g., "smoker" or "non-smoker")
     * @param policyholderHeightInches the height of the policyholder in inches
     * @param policyholderWeightPounds the weight of the policyholder in pounds
     */
    public PolicyHolder(String policyholderFirstName,
                        String policyholderLastName,
                        int policyholderAge,
                        String policyholderSmokingStatus,
                        double policyholderHeightInches,
                        double policyholderWeightPounds) {
        this.policyholderFirstName = policyholderFirstName;
        this.policyholderLastName = policyholderLastName;
        this.policyholderAge = policyholderAge;
        this.setPolicyholderSmokingStatus(policyholderSmokingStatus);
        this.policyholderHeightInches = policyholderHeightInches;
        this.policyholderWeightPounds = policyholderWeightPounds;
    }


    /**
     * Gets the first name of the policyholder.
     *
     * @return the first name of the policyholder
     */
    public String getPolicyholderFirstName() {
        return policyholderFirstName;
    }


    /**
     * Gets the last name of the policyholder.
     *
     * @return the last name of the policyholder
     */
    public String getPolicyholderLastName() {
        return policyholderLastName;
    }


     /**
     * Gets the age of the policyholder.
     *
     * @return the age of the policyholder
     */
    public int getPolicyholderAge() {
        return policyholderAge;
    }
    
    
     /**
     * Gets the smoking status of the policyholder.
     *
     * @return the smoking status of the policyholder (e.g., "smoker" or "non-smoker")
     */
    public String getPolicyholderSmokingStatus() {
        return policyholderSmokingStatus;
    }

    /**
     * Gets the height of the policyholder in inches.
     *
     * @return the height of the policyholder in inches
     */
    public double getPolicyholderHeightInches() {
        return policyholderHeightInches;
    }

    /**
     * Gets the weight of the policyholder in pounds.
     *
     * @return the weight of the policyholder in pounds
     */
    public double getPolicyholderWeightPounds() {
        return policyholderWeightPounds;
    }
    

    /**
     * Calculates the BMI (Body Mass Index) of the policyholder.
     * BMI is calculated as weight (in pounds) * 703 / height (in inches)^2.
     *
     * @return the BMI value of the policyholder
     */
    public double getBMI() {
        if (policyholderHeightInches <= 0) {
            return 0.0;
        }
        return (policyholderWeightPounds * 703.0) /
                (policyholderHeightInches * policyholderHeightInches);
    }


    /**
     * Sets the smoking status for this Policyholder.
     * If the status is not "smoker", it defaults to "non-smoker".
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
}
