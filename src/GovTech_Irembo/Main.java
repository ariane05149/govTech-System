package GovTech_Irembo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            UserManager userManager = new UserManager();

            System.out.println("1. Sign Up");
            System.out.println("2. Login");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print("Create Username: ");
                String username = scanner.nextLine();

                System.out.print("Create Password: ");
                String password = scanner.nextLine();

                userManager.signUp(new User(username, password));

                System.out.println("Account created successfully!");
            }

            System.out.print("Login Username: ");
            String loginUser = scanner.nextLine();

            System.out.print("Login Password: ");
            String loginPass = scanner.nextLine();

            userManager.login(loginUser, loginPass);

            System.out.println("Login successful!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
