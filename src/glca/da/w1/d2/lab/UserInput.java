package glca.da.w1.d2.lab;

import java.util.Scanner;

/*
 * Q1) Write a java program to perform addition of two numbers. Take the user input, 
 * perform and print the values recursively till a stopping criteria is met. 
 * Ask user for stopping criteria. 
 *
 * Example: Press 0 to stop taking the user input.
 * Use appropriate naming convention and logic to implement the same.
 * Try: Write logic to perform other operations. Take the user input for 
 * the operation they want to perform and print the result accordingly.
 */
public class UserInput {

	public static void main(String[] args) {
//		1. create required object to take user input
		Scanner sc = new Scanner(System.in);
		
//		2. Declare variables
		int num1;
		int num2;
		
//		3. Logic to perform the task
		do {
			System.out.println("Enter number 1: ");
			num1 = sc.nextInt();
			
			System.out.println("Enter number 2: ");
			num2 = sc.nextInt();
			
			// Not using 3rd variable to store sum, as we do not have other operations to remember it.
			System.out.println("The sum of two numbers is: "+ (num1+num2));
			
			System.out.println("Type false to stop the loop.\nType true to repeat");
		}while(sc.nextBoolean());
	}
}
