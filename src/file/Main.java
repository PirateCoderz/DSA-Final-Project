package file;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int num = 0;
		CustomerList customerList = new CustomerList();
		Scanner scanner = new Scanner(System.in);
		System.out.println("1. Add\n2. Delete\n3. Update\n ");
		System.out.println("Enter a num: ");
		num = scanner.nextInt();
		scanner.close();

		while (num == 4) {
			
			
			switch (num) {
			case 1:
				// add customers
				System.out.println("Enter customer information (id, name, email):");
				String id = scanner.next();
				String name = scanner.next();
				String email = scanner.next();
				Customers customer = new Customers(id, name, email);
				scanner.close();
				customerList.addCustomer(customer);
				break;

			case 2:
				// delete customers
				System.out.println("Enter customer id to delete:");
				id = scanner.next();
				customerList.deleteCustomer(id);

			case 3:
				// update customers
				System.out.println("Enter customer information to update (id, name, email):");
				id = scanner.next();
				name = scanner.next();
				email = scanner.next();
				Customers newCustomer = new Customers(id, name, email);
				customerList.updateCustomer(id, newCustomer);

			case 4:
				break;
			default: 
				break;
			} 
			
			// save customers to file
			customerList.saveCustomers("customers.dat");

			// load customers from file
			customerList.loadCustomers("customers.dat");
			System.out.println("1. Add\n2. Delete\n3. Update\n ");
			System.out.println("Ente1r a num: ");
			num = scanner.nextInt();

		}

		
	}
}