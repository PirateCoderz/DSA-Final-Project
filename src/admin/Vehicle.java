package admin;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//Class representing a NewVehicle
class NewVehicle {
	String category, number, vehicleName, model;
	int rentPerHour, seatingCapacity;

	NewVehicle(String category, String model, String vehicleName, int rentPerHour, int seatingCapacity) {
		this.category = category;
		this.model = model;
		this.vehicleName = vehicleName;
		this.rentPerHour = rentPerHour;
		this.seatingCapacity = seatingCapacity;
	}

	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}

//Class representing a node in the linked list
class Node {
	NewVehicle data;
	Node next;

	public Node(NewVehicle data) {
		this.data = data;
		this.next = null;
	}
}

//Class representing a linked list
class LinkedList {
	Node head;

	public void insertEnd(NewVehicle vehicle) {
		Node newNode = new Node(vehicle);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void insertFront(NewVehicle vehicle) {
		Node newNode = new Node(vehicle);
		newNode.next = head;
		head = newNode;
	}

	public void deleteFront() {
		if (head == null) {
			return; // List is empty
		}
		head = head.next;
	}

	public void deleteEnd() {
		if (head == null || head.next == null) {
			head = null; // List has 0 or 1 node
			return;
		}
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}

	public int getSize() {
		int count = 0;
		Node current = head;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void push() {
//		MySql sql = new MySql();
		Node current = head;
		while (current != null) {
//			sql.POST(current.data.category, current.data.vehicleName, current.data.rentPerHour,
//					current.data.seatingCapacity);
			System.out.println();
			current = current.next;
		}
	}

	public void display() {
//		MySql sql = new MySql();
		Node current = head;

		if (current == null) {
			System.out.println("No Vehicle is Present...");
			return;
		}

		while (current != null) {
//			sql.POST(current.data.category, current.data.vehicleName, current.data.rentPerHour,
//					current.data.seatingCapacity);
			System.out.print("\nCategory: " + current.data.category);
			System.out.print("\tModel: " + current.data.model);
			System.out.print("\tNumber: " + current.data.number);
			System.out.print("\tRent Per Hour: " + current.data.rentPerHour);
			System.out.print("\tSeating Capacity: " + current.data.seatingCapacity);
			System.out.print("\tVehicle Name: " + current.data.vehicleName);
			System.out.println();
			current = current.next;
		}
	}

	public void insertFront(Customer newCustomer) {
		// TODO Auto-generated method stub

	}
}

//Class representing a stack
class Stack {
	Node top;

	public void push(NewVehicle vehicle) {
		Node newNode = new Node(vehicle);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	// Pop batch of vehicles
	public NewVehicle pop() {
		if (isEmpty()) {
			System.out.println("\t\t\t\t\tStack is empty");
			return null;
		}
		NewVehicle popped = top.data;
		top = top.next;
		return popped;
	}

	// Check empty or not
	public boolean isEmpty() {
		return top == null;
	}

	// View the detail of the latest batch
	public NewVehicle peek() {
		if (isEmpty()) {
			System.out.println("\t\t\t\t\tStack is empty");
			return null;
		}
		return top.data;
	}

	int size; // Variable to store the size of the stack

	public int size() {
		return size;
	}

	public void incrementSize() {
		size++;
	}

	public void decrementSize() {
		size--;
	}

}

//import main.Login;

public class Vehicle {
	LinkedList vehicleList = new LinkedList();

	String category, number, vehicleName, model;
	int rentPerHour, seatingCapacity;

	private static Scanner scanner = new Scanner(System.in);

	// Getters and Setters
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getRentPerHour() {
		return rentPerHour;
	}

	public void setRentPerHour(int rentPerHour) {
		this.rentPerHour = rentPerHour;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setName(String name) {
		this.vehicleName = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	/*
	 * Vehicle Data: String Category, Number, VehicleName, Model int RentPerHour,
	 * SittingCapacity
	 * 
	 */

	public void add() {
		System.out.println("Vehicle Details");

		System.out.print("Vehicle Model: ");
		scanner.nextLine();
		this.model = scanner.nextLine();

		System.out.print("Category: ");
		this.category = scanner.nextLine();

		System.out.print("Vehicle Name: ");
		this.vehicleName = scanner.nextLine();

		System.out.print("Rent Per Hour: ");
		this.rentPerHour = scanner.nextInt();

		System.out.print("Seating Capacity: ");
		this.seatingCapacity = scanner.nextInt();

		NewVehicle v1 = new NewVehicle(category, model, vehicleName, rentPerHour, seatingCapacity);
		vehicleList.insertFront(v1);

		System.out.print("Vehicle is Added");
	}

	public void addVehicle() {

		this.add();

		int choice = 1;

		while (choice == 1) {
			System.out.println("Want to add another Vehicle:\n1. Yes\n2. No");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				this.add();
				break;
			case 2:
				writeVehicleDataToFile();
				break;
			default:
				break;
			}
		}

		// Now after getting every vehicle details to be added, Store them in DB;

		vehicleList.push();
	}

	/*
	 * View Vehicles
	 * 
	 */

	private void writeVehicleDataToFile() {
		try (FileOutputStream fileOutputStream = new FileOutputStream("products.ser");
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			// Check if the list is empty before writing
			if (!vehicleList.isEmpty()) {
				objectOutputStream.writeObject(vehicleList);
				System.out.println("Vehicle data written to products.ser");
			} else {
				System.out.println("No vehicles to write to file. Please add some vehicles first.");
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error writing vehicle data to file.");
		}
	}

	public void displayVehicles() {
//		MySql sql = new MySql();
//		sql.GET();
	}

	public void updateVehicles() {
//		MySql sql = new MySql();
		String mode, cate, vh;
		int id, rph, sc;

		System.out.println("Update Vehicle Details");

		System.out.print("Vehicle ID: ");
		id = scanner.nextInt();
//		scanner.nextLine();

		System.out.print("Model ID: ");

		mode = scanner.nextLine();
		System.out.print("Category: ");
		cate = scanner.nextLine();

		System.out.print("Vehicle Name: ");
		vh = scanner.nextLine();

		System.out.print("Rent Per Hour: ");
		rph = scanner.nextInt();

		System.out.print("Seating Capacity: ");
		sc = scanner.nextInt();

//		sql.UPDATE(id, cate, vh, rph, sc);
//		sql.UPDATE();

	}

	public void deleteVehicle() {
//		MySql sql = new MySql();

		int id;
		System.out.print("Enter ID of Vehicle to be Deleted: ");
		id = scanner.nextInt();

//		sql.DELETE(id);

	}

}