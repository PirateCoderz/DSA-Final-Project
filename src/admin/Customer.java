package admin;

import java.util.LinkedList;
import java.util.Scanner;

public class Customer {
  private String name, email, phone;
  public void addCustomer() {
	  System.out.println("Customer is adding");
  }

  private static LinkedList customerList = new LinkedList();
	Scanner scanner = new Scanner(System.in);
  
  // Constructor and getters/setters for name and email

  public void addCustomer1() {
	  System.out.println("Customer Details");

		System.out.print("Customer Name: ");
		scanner.nextLine();
		this.name = scanner.nextLine();
		
		
		System.out.print("Customer Email: ");
		this.email = scanner.nextLine();

		System.out.print("Customer Phone: ");
		this.phone = scanner.nextLine();
	  
    Customer newCustomer = new Customer();
    
//    customerList.insertFront(newCustomer); // Inserting at the beginning
    System.out.println("Customer added to the list!");
  }

  public void viewCustomer() {
    if (customerList.isEmpty()) {
      System.out.println("No customers found!");
    } else {
      System.out.println("Customer List:");
//      Node current = customerList.head;
//      while (current != null) {
//        System.out.println("Name: " + current.data.getName() + ", Email: " + current.data.getEmail());
//        current = current.next;
      }
    }
//  }

  public void deleteCustomer(String email) {
//    Node current = customerList.head;
    Node previous = null;

    // Traverse the linked list searching for the customer by email
//    while (current != null) {
//      if (current.data.getEmail().equals(email)) {
        if (previous == null) {
          // Delete head node
//          customerList.head = current.next;
        } else {
          // Delete node in the middle or at the end
//          previous.next = current.next;
        }
        System.out.println("Customer deleted successfully!");
        return;
//      }
//      previous = current;
//      current = current.next;
    }

    // Customer not found
//    System.out.println("Customer not found!");
  }
//}
