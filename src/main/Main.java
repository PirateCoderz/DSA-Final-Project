package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("********************************************");
        System.out.println("*  Welcome to Transport Management System  *");
        System.out.println("********************************************");
        System.out.println("*                Login As                  *");
        System.out.println("*  1. Admin                                *");
        System.out.println("*  2. Customer                             *");
        System.out.println("********************************************");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        Login log = new Login();
     
        switch (choice) {
            case 1:
            	
            	// Code for Admin login
                log.Adminlogin();
                break;
            case 2:
                // Code for Customer login
                log.customerlogin();
                
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        
        scanner.close();
        
    }
}
