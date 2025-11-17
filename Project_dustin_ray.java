import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Project_dustin_ray {
    public static void main(String[] args) {
        List<Policy> policies = new ArrayList<>();  
        int smokerCount = 0; 
        int nonSmokerCount = 0;  
        
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("PolicyInformation.txt"));
            while (fileScanner.hasNextLine()) {
                String policyNumber = fileScanner.nextLine();
                String providerName = fileScanner.nextLine();
                String firstName = fileScanner.nextLine();
                String lastName = fileScanner.nextLine();
                int age = Integer.parseInt(fileScanner.nextLine());
                String smokingStatus = fileScanner.nextLine();
                double height = Double.parseDouble(fileScanner.nextLine());
                double weight = Double.parseDouble(fileScanner.nextLine());

                
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
                
                
                if (smokingStatus.equalsIgnoreCase("smoker")) {
                    smokerCount++;
                } else {
                    nonSmokerCount++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred while reading the file.");
            return; 
        } finally {
            if (fileScanner != null) {
                fileScanner.close(); 
            }
        }

        
        for (Policy policy : policies) {
            System.out.println(policy); 
        }

        
        System.out.println("Total number of Policy objects created: " + Policy.getPolicyCount());

        
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}
