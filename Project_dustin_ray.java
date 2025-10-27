import java.io.File; 
import java.util.Scanner; 
import java.util.ArrayList; 
import java.util.List; 

public class Project_dustin_ray {
    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();  // To store all policy objects
        
        // Read the file
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("PolicyInformation.txt"));
            while (fileScanner.hasNextLine()) {
                // Read each line and extract the required details
                String policyNumber = fileScanner.nextLine();
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                // Create a Policy object and add it to the list
                Policy policy = new Policy(
                        policyNumber,
                        providerName,
                        firstName,
                        lastName,
                        age,
                        smokingStatus,
                        height,
                        weight
                );
                policies.add(policy);
            }
        } catch (Exception e) {
            // If the file is not found or any error occurs, print the message and return
            System.out.println("Error occurred while reading the file.");
            return; // Exit if the file cannot be read
        } finally {
            if (fileScanner != null) {
                fileScanner.close(); // Close the scanner after use
            }
        }

        // Process and print out all policies
        for (Policy policy : policies) {
            System.out.println();
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder’s First Name: " + policy.getPolicyholderFirstName());
            System.out.println("Policyholder’s Last Name: " + policy.getPolicyholderLastName());
            System.out.println("Policyholder’s Age: " + policy.getPolicyholderAge());
            System.out.println("Policyholder’s Smoking Status: " + policy.getPolicyholderSmokingStatus());
            System.out.println("Policyholder’s Height: " + policy.getPolicyholderHeightInches() + " inches");
            System.out.println("Policyholder’s Weight: " + policy.getPolicyholderWeightPounds() + " pounds");
            System.out.printf("Policyholder’s BMI: %.2f\n", policy.getBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.calculatePrice());
        }
    }
}
