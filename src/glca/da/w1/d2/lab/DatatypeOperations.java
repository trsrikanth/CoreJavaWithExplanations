package glca.da.w1.d2.lab;

import java.util.Scanner;

/*
 * Q2) Write a java program to 
 * 	Accept the type of input the user wants to insert.
 * 	Store the input in their appropriate data member(variable)
 * 	Show an option to print all the values of all different data type variables created.
 * 	Do the above operations recursively.
 * 
 * If pressed 0, terminate the loop and exit the program.
 */
public class DatatypeOperations {

	public static void main(String[] args) {
//		1. Declare and Initialize objects
		Scanner sc = new Scanner(System.in);

//		2. Declare and initialize variables
		int option;
		int num = 0;
		long phone = 0;
		float decimal = 0;
		double longDecimal = 0; 
		String str = null;
		char ch = 0;
		boolean bool = false;

//		3. Logic to select user data type and insert value
		do {
			System.out.println("Enter the data type you want to insert");
			System.out.println("1. Integer\n2. long Integer\n3. Float\n4. Double\n5. String\n"
					+ "6. character\n7. Boolean\n8.print all value of variables");

			option = sc.nextInt();
//			switch case to insert value in user selected data type
			
			switch(option) {
			case 1:
				System.out.println("Enter integer value:");
				num = sc.nextInt();
				break;
			case 2:
				System.out.println("Enter long int value:");
				phone = sc.nextLong();
				break;
			case 3:
				System.out.println("Enter float value:");
				decimal = sc.nextFloat();
				break;
			case 4:
				System.out.println("Enter double value:");
				longDecimal = sc.nextDouble();
				break;
			case 5:
				System.out.println("Enter String value:");
				str = sc.nextLine();
				break;
			case 6:
				System.out.println("Enter character value:");
				ch = sc.next().charAt(0);
				break;
			case 7:
				System.out.println("Enter boolean value:");
				bool = sc.nextBoolean();
				break;
			case 8:
				System.out.println("\n");
				System.out.println("Integer value \t"+num);
				System.out.println("Long value \t"+phone);
				System.out.println("float value \t"+decimal);
				System.out.println("double value \t"+longDecimal);
				System.out.println("string value \t"+str);
				System.out.println("character value \t"+ch);
				System.out.println("boolean value \t"+bool);
				break;
			default: 
				System.out.println("Incorrect option selected");
			}
//			stopping criteria for do..while loop
			System.out.println("Type true if you want to repeat else false");
		}while(sc.nextBoolean());
	}
}
