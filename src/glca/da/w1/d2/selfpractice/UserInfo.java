package glca.da.w1.d2.selfpractice;

import java.util.Scanner;

/*
 * Q1) Write a Java program, declare three variables called  name of type string, 
 * address of type string and age of type int, get the user input for these variables 
 * and print the values on the console
 */
public class UserInfo {
	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner (System.in);
			
			//Read value for Name,Address and age from user input
			System.out.println("Enter Name:");
			String name = sc.nextLine();
			System.out.println("Enter Address:");
			String address = sc.nextLine();
			System.out.println("Enter Age:");
			int age = sc.nextInt();
			System.out.println("----------------------------------------");
			
			//display all values
			System.out.println("Name is :"+ name);
			System.out.println("Address is :"+ address);
			System.out.println("Age is :"+ age);
	}
}

