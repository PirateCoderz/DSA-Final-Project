package main;

import java.util.Scanner;

public class RailwayReservationSystem {
    private static final String ADMIN_USERNAME = "admin123";
    private static final String ADMIN_PASSWORD = "BulBul";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Railway Reservation System");
        System.out.println("-------------------------------");

        boolean isAdminLoggedIn = adminLogin();

        if (isAdminLoggedIn) {
            System.out.println("Admin Login Successful!");
            adminMenu();
        } else {
            System.out.println("Invalid username or password. Access denied.");
        }

        scanner.close(); // Closing scanner
    }

    private static boolean adminLogin() {
        System.out.println("Admin Login");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    private static void adminMenu() {
        while (true) {
            System.out.println("\nAdministration Menu:");
            System.out.println("1. Create detail of trains");
            System.out.println("2. Display Passengers");
            System.out.println("3. Display Booking Detail");
            System.out.println("7. Return to main menu");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    createTrainsDetail();
                    break;
                case 2:
                    displayPassengers();
                    break;
                case 3:
                    displayBookingDetail();
                    break;
                case 7:
                    System.out.println("Returning to the main menu.");
                    return;
                case 8:
                    System.out.println("Exiting Railway Reservation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createTrainsDetail() {
        while (true) {
            System.out.println("\nDetail of Trains: ");
            System.out.println("1. Add Train Detail");
            System.out.println("2. Check Existing Train");
            System.out.println("3. Search Specific Train");
            System.out.println("4. Delete Train Detail");
            System.out.println("7. Return to main menu");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addTrainDetail();
                    break;
                case 2:
                    checkExistingTrain();
                    break;
                case 3:
                    searchSpecificTrain();
                    break;
                case 4:
                    deleteTrainDetail();
                    break;
                case 7:
                    System.out.println("Returning to the main menu.");
                    return;
                case 8:
                    System.out.println("Exiting Railway Reservation System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTrainDetail() {
        System.out.println("Implement logic for adding train details...");
    }

    private static void checkExistingTrain() {
        System.out.println("Implement logic for checking existing trains...");
    }

    private static void searchSpecificTrain() {
        System.out.println("Implement logic for searching a specific train...");
    }

    private static void deleteTrainDetail() {
        System.out.println("Implement logic for deleting train details...");
    }

    private static void displayPassengers() {
        System.out.println("Implement logic for displaying passengers...");
    }

    private static void displayBookingDetail() {
        System.out.println("Implement logic for displaying booking details...");
    }
}