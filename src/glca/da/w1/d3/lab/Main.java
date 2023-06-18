//package name
package glca.da.w1.d3.lab;

import java.util.Scanner;

/*
 * Q2) Write a program to 
 * 		1. Create a package with two classes Table and Main respectively.
 * 		2. In the Table class create a parameterized constructor accepting two values 
 * 		   multiplicand  and range of multiplier and print the table.
 * 		3. Create an object in the class Main for class Table and execute the code.
 * 		4. Try changing the accessibility of the table class and observe the output.
 * Example: 12, 10 Here 12 is Multiplicand and 10 is multiplier the will we 12 table till 12x10=120
*/
public class Main {

	public static void main(String[] args) {
	
//		1. create object for scanner class
		Scanner sc = new Scanner(System.in);
		
//		2. Take user input for multiplicand and multipli
		System.out.println("What is the integer multiplicand? ");
		int multiplicand = sc.nextInt();
		
		System.out.println("What is the integer multiplier? ");
		int multiplier = sc.nextInt();
		
//		3. Pass the values to the constructor when initializing the object
		Table table = new Table(multiplicand, multiplier);
		
	}
}
