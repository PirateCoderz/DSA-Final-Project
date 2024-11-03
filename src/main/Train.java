package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Train {
    private int trainNumber;
    private String trainName;
    private String destination;
    private int travelTime;
    private int availableSeats;
    private double fareFirstAC;
    private double fareSecondAC;
    private double fareThirdAC;
    private double fareSleeper;
    private String routesRides;

    // Constructor
    public Train(int trainNumber, String trainName, String destination, int travelTime,
                 int availableSeats, double fareFirstAC, double fareSecondAC, double fareThirdAC,
                 double fareSleeper, String routesRides) {
                    this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.destination = destination;
        this.travelTime = travelTime;
        this.availableSeats = availableSeats;
        this.fareFirstAC = fareFirstAC;
        this.fareSecondAC = fareSecondAC;
        this.fareThirdAC = fareThirdAC;
        this.fareSleeper = fareSleeper;
        this.routesRides = routesRides;
    }
 

    // Getters and Setters
    public int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getFareFirstAC() {
        return fareFirstAC;
    }

    public void setFareFirstAC(double fareFirstAC) {
        this.fareFirstAC = fareFirstAC;
    }

    public double getFareSecondAC() {
        return fareSecondAC;
    }

    public void setFareSecondAC(double fareSecondAC) {
        this.fareSecondAC = fareSecondAC;
    }

    public double getFareThirdAC() {
        return fareThirdAC;
    }

    public void setFareThirdAC(double fareThirdAC) {
        this.fareThirdAC = fareThirdAC;
    }

    public double getFareSleeper() {
        return fareSleeper;
    }

    public void setFareSleeper(double fareSleeper) {
        this.fareSleeper = fareSleeper;
    }

    public String getRoutesRides() {
        return routesRides;
    }

    public void setRoutesRides(String routesRides) {
        this.routesRides = routesRides;
    }
    
    @Override
    public String toString() {
        return "Train Number: " + trainNumber + "\nTrain Name: " + trainName +
                "\nDestination: " + destination + "\nTravel Time: " + travelTime +
                " hours\nAvailable Seats: " + availableSeats +
                "\nFare First AC: " + fareFirstAC +
                "\nFare Second AC: " + fareSecondAC +
                "\nFare Third AC: " + fareThirdAC +
                "\nFare Sleeper: " + fareSleeper +
                "\nRoutes and Rides: " + routesRides;
    }

    private static LinkedList<Train> trainsList = new LinkedList<>(); // LinkedList to store trains
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

        return username.equals("admin123") && password.equals("admin");
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
                    // Implement displayPassengers() method
                    break;
                case 3:
                    // Implement displayBookingDetail() method
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
            System.out.println("3. Update Specific Train");
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
                    UpdateSpecificTrain();
                    break;
                case 4:
                    DeleteTrainDetail(scanner);
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
        while (true) {
            System.out.println("Enter Train Details:");
            System.out.print("Train Number: ");
            int trainNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Train Name: ");
            String trainName = scanner.nextLine();
            System.out.print("Destination: ");
            String destination = scanner.nextLine();
            System.out.print("Travel Time (HH--mm--ss): ");
            int travelTime = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Available Seats: ");
            int availableSeats = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter price for First AC: $");
            double fareFirstAC = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter price for Second AC: $");
            double fareSecondAC = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter price for Third AC: $");
            double fareThirdAC = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.print("Enter price for Sleeper class: $");
            double fareSleeper = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character
            System.out.print("Routes and Rides: ");
            String routesRides = scanner.nextLine();

            Train train = new Train(trainNumber, trainName, destination, travelTime,
                    availableSeats, fareFirstAC, fareSecondAC, fareThirdAC, fareSleeper, routesRides);
            trainsList.add(train);

            writeToFile(train);

            System.out.println("Train details added successfully!");
            System.out.print("Do you want to continue adding train details? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                break; // Exit method if user doesn't want to continue
            }
        }
    }
        
        
        private static void writeToFile(Train train) {
            try (FileWriter writer = new FileWriter("train_details.txt", true)) {
                writer.write(train.toString() + "\n"); // Writing train details to file
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
         }
    }
    private static void checkExistingTrain() {
        System.out.print("Enter Train Number to check: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean exists = false;
        for (Train train : trainsList) {
            if (train.getTrainNumber() == trainNumber) {
                exists = true;
                System.out.println("Train exists:");
                System.out.println(train);
                break;
            }
        }
        if (!exists) {
            System.out.println("Train with Train Number " + trainNumber + " does not exist.");
        }

        // Prompt user to add another train detail
        System.out.print("Do you want to add another train detail? (yes/no): ");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
            addTrainDetail(); // Continue adding train details
        }
    }

    private static void UpdateSpecificTrain() {
        System.out.print("Enter Train Number to update: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        boolean found = false;
        for (Train train : trainsList) {
            if (train.getTrainNumber() == trainNumber) {
                found = true;
                System.out.println("Enter updated Train Details:");
                System.out.print("Train Name: ");
                String trainName = scanner.nextLine();
                System.out.print("Destination: ");
                String destination = scanner.nextLine();
                System.out.print("Travel Time (HH--mm--ss): ");
                int travelTime = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Available Seats: ");
                int availableSeats = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter updated price for First AC: $");
                double fareFirstAC = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter updated price for Second AC: $");
                double fareSecondAC = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter updated price for Third AC: $");
                double fareThirdAC = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter updated price for Sleeper class: $");
                double fareSleeper = scanner.nextDouble();
                scanner.nextLine(); // Consume newline character
                System.out.print("Enter updated Routes and Rides: ");
                String routesRides = scanner.nextLine();

                // Update train details
                train.setTrainName(trainName);
                train.setDestination(destination);
                train.setTravelTime(travelTime);
                train.setAvailableSeats(availableSeats);
                train.setFareFirstAC(fareFirstAC);
                train.setFareSecondAC(fareSecondAC);
                train.setFareThirdAC(fareThirdAC);
                train.setFareSleeper(fareSleeper);
                train.setRoutesRides(routesRides);

                System.out.println("Train details updated successfully!");
                break;
            }
        }

        if (!found) {
            System.out.println("Train with Train Number " + trainNumber + " not found.");
        }
    }

    private static void DeleteTrainDetail(Scanner scanner) {
        System.out.print("Enter Train Number to delete: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        for (int i = 0; i < trainsList.size(); i++) {
            Train train = trainsList.get(i);
            if (train.getTrainNumber() == trainNumber) {
                trainsList.remove(i);
                System.out.println("Train with Train Number " + trainNumber + " deleted successfully!");
                break;
            }

        }
    }
}