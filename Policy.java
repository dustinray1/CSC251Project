public class Policy {

   private static int policyCount = 0;

    // Variable fields
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyholder;  
    
    
    /**
     * Constructor to initialize the Policy with a policy number, provider name, and the associated PolicyHolder.
     *
     * @param policyNumber the policy number for this policy
     * @param providerName the name of the provider for this policy
     * @param policyholder the associated policyholder for this policy
     */
    public Policy(String policyNumber, String providerName, PolicyHolder policyholder) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyholder = policyholder;
        
        policyCount++;
    }
    
     /**
     * Gets the total number of Policy objects created.
     *
     * @return the total number of Policy objects created
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Calculates the price of the policy based on the policyholder's age, smoking status, and BMI.
     * - Age over 50 adds $75 to the base price.
     * - Smoking status of "smoker" adds $100 to the base price.
     * - A BMI over 35 adds an additional fee based on the excess BMI.
     *
     * @return the calculated price of the policy
     */
    public double calculatePrice() {
        double price = 600.0;
        if (policyholder.getPolicyholderAge() > 50) {
            price += 75.0;
        }
        if (policyholder.getPolicyholderSmokingStatus().equals("smoker")) {
            price += 100.0;
        }
        double bmi = policyholder.getBMI();
        if (bmi > 35.0) {
            double additionalFee = (bmi - 35.0) * 20.0;
            price += additionalFee;
        }
        return price;
    }
    
    /**
     * Returns a string representation of the Policy object.
     * This will include the policy number, provider name, and policyholder details.
     *
     * @return a string representation of the Policy
     */
    @Override
    public String toString() {
        return "Policy {" +
                "Policy Number='" + policyNumber + '\'' +
                ", Provider Name='" + providerName + '\'' +
                ", Policyholder=" + policyholder.toString() +
                '}';
}

}
