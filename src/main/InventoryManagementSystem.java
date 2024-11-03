package main;

import java.util.Scanner;

// Class representing a Product
class Product {
	int id;
	String name;
	int quantity;
	double price;

	public Product(int id, String name, int quantity, double price) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
}

// Class representing Inventory Management System
class Inventory {
	LinkedList inventoryList = new LinkedList();
	Stack restockStack = new Stack();
	Queue ordersQueue = new Queue();

	// Method to add a product to the end of inventory
	public void addProductToEnd(Product product) {
		inventoryList.insertEnd(product); // Add product to the end of inventory
	}

	// Method to add a product to the front of inventory
	public void addProductToFront(Product product) {
		inventoryList.insertFront(product); // Add product to the front of inventory
	}

	// Method to display the inventory
	public void displayInventory() {
		inventoryList.display();
	}

	// Method to delete a product from the front of inventory
	public void deleteProductFromFront() {
		inventoryList.deleteFront();
	}

	// Method to get the size of the inventory
	public int getInventorySize() {
		return inventoryList.getSize();
	}

	// Method to delete a product from the end of inventory
	public void deleteProductFromEnd() {
		inventoryList.deleteEnd();
	}

	// Method to check if the inventory is empty
	public boolean isInventoryEmpty() {
		return inventoryList.isEmpty();
	}

	// Method to restock a product
	public void restockProduct(Product restockProduct, int quantity) {
		restockProduct.quantity += quantity;
		restockStack.push(restockProduct);
		System.out.println("\n\t\t\t\t\tProduct restocked suuccessfully...");
	}

	// Method to remove a product from the inventory and the restock stack
	public void popProduct(int id) {
		Node prev = null;
		Node current = inventoryList.head;
		// Traverse the list to find the product with the given id
		while (current != null && current.data.id != id) {
			prev = current;
			current = current.next;
		}
		// If product is found, remove it from the list
		if (current != null) {
			if (prev == null) {
				// If the product to be removed is the head of the list
				inventoryList.head = current.next;
			} else {
				prev.next = current.next;
			}
			System.out.println("\n\t\t\t\t\tProduct Removed Successfully...");

			// Now remove the product from the stack as well
			restockStack.pop();
		} else {
			System.out.println("\n\t\t\t\t\tProduct not found in inventory.");
		}

	}

	// Method to peek at the top restocked product
	public Product peekRestockProduct() {
		if (restockStack.isEmpty()) {
			System.out.println("\t\t\t\t\tStack is empty");
			return null;
		}
		return restockStack.peek();
	}

	// Method to find a product by ID
	public Product findProductById(int id) {
		Node current = inventoryList.head;
		while (current != null) {
			if (current.data.id == id) {
				return current.data;
			}
			current = current.next;
		}
		return null; // Product not found
	}

	// Method to find a product by ID
	public int getTotalProducts() {
		return inventoryList.getSize();
	}

	// Method to process a customer order
	public void processOrder(Order order) {
		Product orderedProduct = order.product;
		if (orderedProduct != null && orderedProduct.quantity >= order.quantity) {
			orderedProduct.quantity -= order.quantity;
			ordersQueue.enqueue(order);
			System.out.println("\n\t\t\t\t\tOrder processed successfully. Remaining quantity of " + orderedProduct.name
					+ ": " + orderedProduct.quantity);
		} else {
			System.out.println("\n\t\t\t\t\tInsufficient quantity in inventory for the ordered product.\n");
		}
	}

	// Method to process the next customer order
	public Order processNextOrder() {
		Order nextOrder = ordersQueue.dequeue();
		if (nextOrder != null) {
			System.out.println("\t\t\t\t\tOrder processed ID: " + nextOrder.id);
		} else {
			System.out.println("\t\t\t\t\tNo pending orders to process.");
		}
		return nextOrder;
	}

	// Method to get the next order to be processed
	public Order getNextOrderToProcess() {
		return ordersQueue.front();
	}

	// Method to display pending orders
	public void displayPendingOrders() {
		ordersQueue.display();
	}

	// Method to get the total number of pending orders
	public int getTotalPendingOrders() {
		return ordersQueue.size();
	}

}

// Class representing a customer order
class Order {
	int id;
	String customerName;
	Product product;
	int quantity;

	public Order(int id, String customerName, Product product, int quantity) {
		this.id = id;
		this.customerName = customerName;
		this.product = product;
		this.quantity = quantity;
	}

}

// Class representing a node in the linked list
class Node {
	Product data;
	Node next;

	public Node(Product data) {
		this.data = data;
		this.next = null;
	}
}

// Class representing a linked list
class LinkedList {
	Node head;

	public void insertEnd(Product product) {
		Node newNode = new Node(product);
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

	public void insertFront(Product product) {
		Node newNode = new Node(product);
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

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.println("\n\t\t\t\t\tID: " + current.data.id);
			System.out.println("\n\t\t\t\t\tName: " + current.data.name);
			System.out.println("\n\t\t\t\t\tQuantity: " + current.data.quantity);
			System.out.println("\n\t\t\t\t\tPrice: " + current.data.price);
			System.out.println();
			current = current.next;
		}
	}

}

// Class representing a stack
class Stack {
	Node top;

	public void push(Product product) {
		Node newNode = new Node(product);
		if (top == null) {
			top = newNode;
		} else {
			newNode.next = top;
			top = newNode;
		}
	}

	// Pop batch of products
	public Product pop() {
		if (isEmpty()) {
			System.out.println("\t\t\t\t\tStack is empty");
			return null;
		}
		Product popped = top.data;
		top = top.next;
		return popped;
	}

	// Check empty or not
	public boolean isEmpty() {
		return top == null;
	}

	// View the detail of the latest batch
	public Product peek() {
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


class OrderNode {
	Order data;
	OrderNode next;

	public OrderNode(Order order) {
		this.data = order;
		this.next = null;
	}
}

// Class representing a queue
class Queue {
	OrderNode front;
	OrderNode rear;

	public void enqueue(Order order) {
		OrderNode newNode = new OrderNode(order);
		if (rear == null) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
	}

	public Order dequeue() {
		if (front == null) {
			return null; // Queue is empty
		}
		Order removedOrder = front.data;
		front = front.next;
		if (front == null) {
			rear = null; // Queue becomes empty after dequeuing
		}
		return removedOrder;
	}

	public Order front() {
		if (isEmpty()) {
			return null;
		}
		return front.data;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public int size() {
		int count = 0;
		OrderNode current = front;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public void display() {
		OrderNode current = front;
		while (current != null) {
			System.out.println("\n\t\t\t\t\tID: " + current.data.id);
			System.out.println("\n\t\t\t\t\tCustomer Name: " + current.data.customerName);
			System.out.println("\n\t\t\t\t\tProduct: " + current.data.product.name);
			System.out.println("\n\t\t\t\t\tQuantity: " + current.data.quantity);
			System.out.println();
			current = current.next;
		}
	}

}

public class InventoryManagementSystem {
	private Inventory inventory = new Inventory(); // Instantiate Inventory once

	public static void main(String[] args) {

		InventoryManagementSystem inventory = new InventoryManagementSystem();
		inventory.frontPage();
		inventory.Main();
	}

	public void frontPage() {

		// Method to display front page
		System.out.println("\n\n\t\t\t\t\t\t *******************************************************");
		System.out.println(" \t\t\t\t\t\t    ===============  Assignment   ===============\n");
		System.out.println("\t\t\t\t\t\t *******************************************************\n\n");
		System.out.println(" \t\t\t\t Submitted to:\t\t Mr. Waqar Hussain\n");
		System.out.println(" \t\t\t\t Submitted By:\t\t Nasiha(225354) & Adan(225351)\n");
		System.out.println(" \t\t\t\t Subject:\t\t Data Structure & Algorithm (4th Semester)\n");
		System.out.println(" \t\t\t\t Department:\t\t Computer Science\n");
		System.out.println(" \t\t\t\t Institute:\t\t GC University Chiniot Campus\n");
		System.out.println();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to continue...");
		scanner.nextLine();
		System.out.println("\033c");
	}

	// Method to display main menu and handle user choices
	public void Main() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\t\t\t\t\t\t   ***********************************");
			System.out.println("\t\t\t\t\t\t\tInvetory Management System");
			System.out.println("\t\t\t\t\t\t   ***********************************\n");
			System.out.println("\t\t\t\t\t\t\t1. Manage Product Inventory.");
			System.out.println("\n\t\t\t\t\t\t\t2. Restock Products.");
			System.out.println("\n\t\t\t\t\t\t\t3. Process Customer Orders.");
			System.out.println("\n\t\t\t\t\t\t\t4. Exit.");
			System.out.print("\n\t\t\t\t\t\t\tEnter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("\033c");
				inventoryMenu();

				break;
			}
			case 2: {
				System.out.println("\033c");
				restockingMenu();
				break;
			}
			case 3: {
				System.out.println("\033c");
				customerMenu();
				break;
			}
			default:
				System.out.println("\n\t\t\t\t\tInvalid choice, Please try again...");
				System.out.println("\033c");
				break;

			}
		} while (true);

	}

	// Method to handle customer-related functionalities
	public void customerMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\t\t\t\t\t\t\t   ***********************************");
			System.out.println("\t\t\t\t\t\t\t    Order Processing");
			System.out.println("\t\t\t\t\t\t\t   ***********************************\n");
			System.out.println("\t\t\t\t\t\t\t1. Place Order.");
			System.out.println("\n\t\t\t\t\t\t\t2. Process and remove the completed order.");
			System.out.println("\n\t\t\t\t\t\t\t3. Next Order to be Processed");
			System.out.println("\n\t\t\t\t\t\t\t4. Display Pending Orders");
			System.out.println("\n\t\t\t\t\t\t\t5. Total Pending Orders");
			System.out.println("\n\t\t\t\t\t\t\t6. Exit");
			System.out.print("\n\t\t\t\t\t\t\tEnter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("\033c");
				System.out.print("\t\t\t\t\tEnter customer ID: ");
				int customerID = sc.nextInt();
				sc.nextLine();
				System.out.print("\n\t\t\t\t\tEnter customer name: ");
				String customerName = sc.nextLine();
				System.out.print("\n\t\t\t\t\tEnter product ID: ");
				int productId = sc.nextInt();
				System.out.print("\n\t\t\t\t\tEnter order quantity: ");
				int orderQuantity = sc.nextInt();

				Product product = inventory.findProductById(productId);
				if (product != null) {
					Order order = new Order(customerID, customerName, product, orderQuantity);
					inventory.processOrder(order);
				} else {
					System.out.println("\n\t\t\t\t\tProduct not found in the inventory.");
				}
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");

				break;
			}
			case 2: {
				System.out.println("\033c");
				Order completedOrder = inventory.processNextOrder();
				if (completedOrder != null) {
					System.out.println("\n\t\t\t\t\tCustomer ID: " + completedOrder.id);
					System.out.println("\n\t\t\t\t\tCustomer Name: " + completedOrder.customerName);
					System.out.println("\n\t\t\t\t\tProduct: " + completedOrder.product.name);
					System.out.println("\n\t\t\t\t\tQuantity: " + completedOrder.quantity);
				} else {
					System.out.println("\n\t\t\t\t\tNo pending orders to process.");
				}
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 3: {
				Order nextOrder = inventory.getNextOrderToProcess();
				System.out.println("\033c");
				if (nextOrder != null) {
					System.out.println("\t\t\t\t\tNext order to be processed:");
					System.out.println("\n\t\t\t\t\tCustomer ID: " + nextOrder.id);
					System.out.println("\n\t\t\t\t\tCustomer Name: " + nextOrder.customerName);
					System.out.println("\n\t\t\t\t\tProduct: " + nextOrder.product.name);
					System.out.println("\n\t\t\t\t\tQuantity: " + nextOrder.quantity);
				} else {
					System.out.println("\n\t\t\t\t\tNo pending orders to process.");
				}
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;

			}
			case 4: {
				inventory.displayPendingOrders();
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 5: {
				System.out.println("\033c");
				System.out.println("\n\t\t\t\t\tTotal pending orders: " + inventory.getTotalPendingOrders());
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 6: {
				System.out.println("\n\t\t\t\t\tExiting...");
				System.out.println("\033c");
				Main();
			}
			default:
				System.out.println("\n\t\t\t\t\tInvalid choice, Please try again...");
				System.out.println("\033c");
				break;
			}
		} while (true);

	}

	// Method to handle restocking-related functionalities
	public void restockingMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\t\t\t\t\t   ***********************************");
			System.out.println("\t\t\t\t\t\tManage Product Restocking");
			System.out.println("\t\t\t\t\t   ***********************************\n");
			System.out.println("\n\t\t\t\t\t1. Add product to the inventory");
			System.out.println("\n\t\t\t\t\t2. View details of latest restocked product");
			System.out.println("\n\t\t\t\t\t3. Remove product from inventory");
			System.out.println("\n\t\t\t\t\t4. Check invetory is empty or not.");
			System.out.println("\n\t\t\t\t\t5. View total number of products in the inventory.");
			System.out.println("\n\t\t\t\t\t6. Exit");
			System.out.print("\n\t\t\t\t\tEnter your choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("\033c");
				System.out.println("\t\t\t\t\t   ***********************************");
				System.out.println("\t\t\t\t\t\t    Product Restocking");
				System.out.println("\t\t\t\t\t   ***********************************\n");
				System.out.print("\t\t\t\t\tEnter product ID to restock: ");
				int restockId = sc.nextInt();
				System.out.print("\n\t\t\t\t\tEnter product quantity to restock: ");
				int restockquantity = sc.nextInt();
				Product restockProduct = inventory.findProductById(restockId);
				if (restockProduct != null) {
					inventory.restockProduct(restockProduct, restockquantity);
				} else {
					System.out.println("\n\t\t\t\t\tProduct not found in the inventory.");
				}
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 2: {
				System.out.println("\033c");
				System.out.println("\t\t\t\t   ***********************************");
				System.out.println("\t\t\t\t     View Latest Restocked Product ");
				System.out.println("\t\t\t\t   ***********************************\n");
				Product topRestockedProduct = inventory.peekRestockProduct();
				if (topRestockedProduct != null) {
					System.out.println("\t\t\t\t\tproduct ID: " + topRestockedProduct.id);
					System.out.println("\n\t\t\t\t\tName: " + topRestockedProduct.name);
					System.out.println("\n\t\t\t\t\tQuantity: " + topRestockedProduct.quantity);
					System.out.println("\n\t\t\t\t\tPrice: " + topRestockedProduct.price);
				}
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;

			}
			case 3: {
				// Pop product from inventory
				System.out.println("\033c");
				System.out.println("\t\t\t\t   ***********************************");
				System.out.println("\t\t\t\t\t    Remove Product");
				System.out.println("\t\t\t\t   ***********************************\n");
				System.out.print("\t\t\t\t\tEnter product ID to remove: ");
				int removeId = sc.nextInt();
				inventory.popProduct(removeId);

				// Display inventory
				inventory.displayInventory();
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 4: {
				System.out.println("\033c");
				if (inventory.isInventoryEmpty()) {
					System.out.println("\n\t\t\t\t\tInventory is empty.");
				} else {
					System.out.println("\n\t\t\t\t\tInvetory is not empty.");
				}
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 5: {
				System.out.println("\033c");
				System.out
						.println("\n\t\t\t\t\tTotal number of products in inventory: " + inventory.getTotalProducts());
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 6: {
				System.out.println("\t\t\t\t\tExiting...");
				System.out.println("\033c");
				Main();
			}
			default:
				System.out.println("\t\t\t\t\tInvalid choice, Please try again...");
				System.out.println("\033c");
				break;
			}
		} while (true);
	}

	// Method to handle inventory-related functionalities
	public void inventoryMenu() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\033c");
			System.out.println("\t\t\t\t\t   ***********************************");
			System.out.println("\t\t\t\t\t\t  Product Inventory");
			System.out.println("\t\t\t\t\t   ***********************************\n");
			// System.out.println("\033c");
			System.out.println("\n\t\t\t\t\t1. Insert product at front");
			System.out.println("\n\t\t\t\t\t2. Insert product at end");
			System.out.println("\n\t\t\t\t\t3. Delete product from front");
			System.out.println("\n\t\t\t\t\t4. Delete product from end");
			System.out.println("\n\t\t\t\t\t5. Check if inventory is empty");
			System.out.println("\n\t\t\t\t\t6. Display inventory");
			System.out.println("\n\t\t\t\t\t7. Get size of inventory");
			System.out.println("\n\t\t\t\t\t8. Exit");
			System.out.print("\n\t\t\t\t\tEnter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("\033c");
				System.out.print("\t\t\t\t\tEnter product ID: ");
				int id1 = sc.nextInt();
				sc.nextLine();
				System.out.print("\n\t\t\t\t\tEnter product name: ");
				String name1 = sc.nextLine();
				System.out.print("\n\t\t\t\t\tEnter quantity: ");
				int quantity1 = sc.nextInt();
				System.out.print("\n\t\t\t\t\tEnter price: ");
				double price1 = sc.nextDouble();
				Product p1 = new Product(id1, name1, quantity1, price1);
				System.out.println("\n\t\t\t\t\tProduct Added Successfully...");
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 2: {
				System.out.println("\033c");

				System.out.print("\t\t\t\t\tEnter product ID: ");
				int id1 = sc.nextInt();
				sc.nextLine();
				System.out.print("\n\t\t\t\t\tEnter product name: ");
				String name1 = sc.nextLine();
				System.out.print("\n\t\t\t\t\tEnter quantity: ");
				int quantity1 = sc.nextInt();
				System.out.print("\n\t\t\t\t\tEnter price: ");
				double price1 = sc.nextDouble();
				Product p1 = new Product(id1, name1, quantity1, price1);
				inventory.addProductToEnd(p1);
				System.out.println("\n\t\t\t\t\tProduct Added Successfully...");
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 3: {
				inventory.deleteProductFromFront();
				System.out.println("\n\t\t\t\t\tProduct Deleted Successfully from Front...");
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 4: {
				inventory.deleteProductFromEnd();
				System.out.println("\n\t\t\t\t\tProduct Deleted Successfully from End...");
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 5: {
				if (inventory.isInventoryEmpty()) {
					System.out.println("\n\t\t\t\t\tInventory is empty.");
				} else {
					System.out.println("\n\t\t\t\t\tInventory is not empty.");
				}
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 6: {
				System.out.println("\033c");
				System.out.println("\t\t\t\t\tDisplay all product from the invetory.");
				inventory.displayInventory();
				System.out.print("\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 7: {
				System.out.println("\n\t\t\t\t\tInventory size is: " + inventory.getInventorySize());
				System.out.print("\n\t\t\t\t\tPress 1 to continue: ");
				sc.nextInt();
				System.out.println("\033c");
				break;
			}
			case 8: {
				System.out.println("\t\t\t\t\tExisting...");
				System.out.println("\033c");
				Main();
			}
			default:
				System.out.println("\t\t\t\t\tInvalid choice, Please try again...");
				System.out.println("\033c");
				break;
			}
		} while (true);
	}
}