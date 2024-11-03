package main;

import java.util.Scanner;

import admin.Vehicle;
import admin.Vehicles;
import admin.Customer;

class Admin {

	private String email;
	private String password;

	private String name;
	private int ID;
	private String contactNo;

	// Constructor
	public Admin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public int getID() {
		return ID;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void manage() {
		Scanner scanner = new Scanner(System.in);
		Vehicles vehicle = new Vehicles();
		Customer customer = new Customer();
		
		int choice;

		do {
			System.out.println('\u000C');
			System.out.println("\n1. Add Vehicle");
			System.out.println("2. Update Vehicle");
			System.out.println("3. Delete Vehicle");
			System.out.println("4. Rented Vehicle");
			System.out.println("5. Check Available Vehicles");
			System.out.println("6. Add customer");
			System.out.println("7. View Customers");
			System.out.println("8. Delete Customers");
			System.out.println("9. Manage Transaction");
			System.out.println("10.Display Slip");
			System.out.println("11.Logout");
			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();

			
			switch (choice) {
			case 1:
				vehicle.addVehicle();
				break;
			case 2:
//				vehicle.updateVehicles();
				break;
			case 3:
//				vehicle.deleteVehicle();
				break;
			case 4:
				rentedVehicle();
				break;
			case 5:
//				vehicle.displayVehicles();
				break;
			case 6:
				customer.addCustomer();
				break;
			case 7:
//				viewCustomer();
				break;
			case 8:
//				deleteCustomer();
				break;
			case 9:
				manageTransaction();
				break;
			case 10:
				displayslip();
			case 11:
				System.out.println("Logging out...");
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 10);

		scanner.close();
	}

//    private void addVehicle() {
//        Vehicle vehicle = new Vehicle();
//        vehicle.addVehicle(); 
//    }

//	private void updateVehicle() {
//		// Implementation goes here
//	}

	private void rentedVehicle() {
		// Implementation goes here
	}

	public void addCustomer() {
		// Implementation goes here
	}

	private void viewCustomer() {
		// Implementation goes here
	}

	private void deleteCustomer() {
		// Implementation goes here
	}

	private void manageTransaction() {
		// Implementation goes here
	}

	private void displayslip() {
		// Implementation goes here
	}
//    public static void main(String[] args) {
//        // Create an instance of Admin and call manage method
//        Admin admin = new Admin("Admin", "password", 1234, "1234567890");
//        admin.manage();
//    }
}
