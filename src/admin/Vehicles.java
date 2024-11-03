package admin;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

class Node {
	Vehicles data;
	Node next;

	public Node(Vehicles data) {
		this.data = data;
		this.next = null;
	}
}


//Class representing a linked list
class LinkedList {
	Node head;

	public void insertEnd(Vehicles vehicle) {
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

	public void insertFront(Vehicles vehicle) {
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

public class Vehicles {
	String category, number, vehicleName, model;
	int rentPerHour, seatingCapacity;
	
	Vehicles(String category, String model, String vehicleName, int rentPerHour, int seatingCapacity) {
		this.category = category;
		this.model = model;
		this.vehicleName = vehicleName;
		this.rentPerHour = rentPerHour;
		this.seatingCapacity = seatingCapacity;
	}
	
	

	
	public Vehicles() {
		// TODO Auto-generated constructor stub
	}




	LinkedList vehicleList = new LinkedList();

	private static Scanner scanner = new Scanner(System.in);
	
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

		Vehicles v1 = new Vehicles(category, model, vehicleName, rentPerHour, seatingCapacity);
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
				
				break;
			default:
				break;
			}
		}

		// Now after getting every vehicle details to be added, Store them in DB;

		vehicleList.push();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
