package main;

import java.util.Scanner;

public class Login {
	public boolean isAdminLoggedin = false;
	public boolean iscustomerLoggedin = false;

	private static Scanner scanner = new Scanner(System.in);

	public boolean validateLogin(String ADMIN_EMAIL, String ADMIN_PASSWORD) {
		System.out.println("Login Page");
		System.out.print("Email: ");
		String email = scanner.nextLine();
		System.out.print("Password: ");
		String password = scanner.nextLine();

		return email.equals(ADMIN_EMAIL) && password.equals(ADMIN_PASSWORD);
	}

	public void Adminlogin() {
		Admin admin = new Admin("a", "p");
		isAdminLoggedin = validateLogin(admin.getEmail(), admin.getPassword());

		if (isAdminLoggedin) {
			System.out.println("Loggedin Successful");
			admin.manage();
		} else {
			System.out.println("Loggedin Failed");
			isAdminLoggedin = validateLogin(admin.getEmail(), admin.getPassword());
		}
	}

//	public void customerlogin() {
//		Customering customer = new Customering("c", "p");
//		iscustomerLoggedin = validateLogin(customer.getEmail(), customer.getPassword());
//
//		if (iscustomerLoggedin) {
//			System.out.println("Loggedin Successful");
//			customer.customerManage();
//			
//		} else {
//			System.out.println("Loggedin Failed");
//		}
//
//	}
}
