package GovTech_Irembo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        try {

            UserManager userManager = new UserManager();
            ApplicationManager appManager = new ApplicationManager();

            System.out.println("=== Welcome to GovTech Irembo System ===");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");

            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {

                System.out.print("Create Username: ");
                String newUsername = input.nextLine();

                System.out.print("Create Password: ");
                String newPassword = input.nextLine();

                userManager.signUp(new User(newUsername, newPassword));

                System.out.println("Account created successfully!");
            }

            System.out.print("Login Username: ");
            String loginUser = input.nextLine();

            System.out.print("Login Password: ");
            String loginPass = input.nextLine();

            userManager.login(loginUser, loginPass);

            System.out.println("Login successful!\n");

            System.out.println("Choose Service:");
            System.out.println("1. Birth Certificate (500 RWF)");
            System.out.println("2. Residence Certificate (1500 RWF)");

            int serviceChoice = input.nextInt();
            input.nextLine();

            GovernmentService chosenService;

            if (serviceChoice == 1) {
                chosenService = new BirthCertificateService();
            } else {
                chosenService = new ResidenceCertificateService();
            }

            System.out.print("Full Name: ");
            String name = input.nextLine();

            System.out.print("Phone Number: ");
            String phone = input.nextLine();

            System.out.print("Email Address: ");
            String email = input.nextLine();

            Citizen citizen;

            if (serviceChoice == 1) {

                // Birth Certificate → Only Rwandan allowed
                System.out.print("Enter National ID (16 digits): ");
                String id = input.nextLine();

                citizen = new RwandanCitizen(name, phone, email, id);

            } else {

                // Residence Certificate → Choose nationality
                System.out.println("Select Nationality:");
                System.out.println("1. Rwandan");
                System.out.println("2. Foreigner");

                int nationalityChoice = input.nextInt();
                input.nextLine();

                if (nationalityChoice == 1) {

                    System.out.print("Enter National ID (16 digits): ");
                    String id = input.nextLine();

                    citizen = new RwandanCitizen(name, phone, email, id);

                } else {

                    System.out.print("Enter Passport Number: ");
                    String passport = input.nextLine();

                    citizen = new Foreigner(name, phone, email, passport);
                }
            }

            ServiceApplication application =
                    new ServiceApplication(citizen, chosenService);

            appManager.addApplication(application);

            System.out.println("Application submitted successfully!");
            System.out.println("Application ID: "
                    + application.getApplicantId());

            appManager.approveApplication(
                    application.getApplicantId());

            System.out.println("Application Approved!");

            double revenue = appManager.calculateRevenue();

            System.out.println("Total Revenue Generated: "
                    + revenue + " RWF");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
