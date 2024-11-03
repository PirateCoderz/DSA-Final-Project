package main;

import java.util.Scanner;

import admin.Vehicle;

class Customering {

	private String email;
	private String password;

	// Constructor
	public Customering(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// Getters and setters for email
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void customerManage() {
		Scanner scanner = new Scanner(System.in);

		// Once logged in, proceed with customer management
		boolean exit = false;

		do {
			System.out.println("\nWelcome to the customer management system!");
			System.out.println("Choose an option:");
			System.out.println("1. View vehicles");
			System.out.println("2. Reserve a vehicle");
			System.out.println("3. Pay rent");
			System.out.println("4. Logout");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				Vehicle vehicle = new Vehicle();
				vehicle.displayVehicles();
				break;
			case 2:
				reserveVehicle();
				break;
			case 3:
				payRent();
				break;
			case 4:
				exit = true;
				System.out.println("Logging out...");
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		} while (!exit);
		scanner.close();
	}

	private void viewVehicles() {
		// Implementation goes here
	}

	private void reserveVehicle() {
		// Implementation goes here
	}

	private void payRent() {
		// Implementation goes here
	}

}