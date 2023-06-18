package glca.da.w1.d1.lab;

import java.util.Scanner;

/*
 * Q1) Write a program in java to print a Welcome message, Your name, 
 * Email address and Phone Number using variables.
*/
public class ClientDetails {

	public static void main(String[] args) {
		
//		1. Declare variables
		String welcomeMessage;
		String name;
		String email;
		long contact;
		
//		2. Initialize or assign values to variables/ data members
		welcomeMessage = "Welcome to GLCA Backend Development Training";
		name = "Joseph Pinto";
		email = "joseph@gmail.com";
		contact = 9898989898L;
		
//		3. Print the values
		System.out.println(welcomeMessage);
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		System.out.println("contact: "+contact);
	}

	private static void declareInitializePrintUsingScanner() {
		Scanner scanner = new Scanner(System.in);
		// 1. Declare variables
		String welcomeText;
		String name;
		String email;
		long contactNumber;

		// 2. Initialize or assign values to variables/ data members

		welcomeText = "Welcome to GLCA Backend Development Training";
		System.out.println("Enter name : ");
		name= scanner.nextLine();
		System.out.println("Enter email: ");
		email= scanner.nextLine();
		System.out.println("Enter contact number");
		contactNumber=Long.parseLong(scanner.nextLine());

		//3. Print the values

		System.out.println(welcomeText);
		System.out.println("Name: "+name);
		System.out.println("Email: "+email);
		System.out.println("Contact: "+ contactNumber);
	}
}
