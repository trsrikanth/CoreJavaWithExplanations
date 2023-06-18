//package name
package glca.da.w1.d3.lab;

import java.util.Scanner;

/*
 * Q3) Write a java program to create a method with a name pattern and 
 * 	   print an inverted triangle pattern as shown below.
 * 	   Take the number of rows from the user.
 */
public class InvertedVPattern {
	
//	1. Declare required variables
	private int i, j, k, rows;
	
//	2. create object for scanner class
	Scanner sc = new Scanner(System.in);
	
//	3. create a method to implement the logic
	private void pattern() {
		
		// a. Accept the no of rows from user
		System.out.println("No of rows needed to print the pattern: ");
		rows = sc.nextInt();
		
		// b. create an outer for loop as per rows
		for (i=rows; i>= 1 ; i--) {
			
			// i) logic to print spaces before first start
			for (j = i; j<rows; j++) {
				System.out.print(" ");
			}
			
			// ii) logic to print from first start to last start in a row
			for (k = 1; k <= (2*i -1);k++) {
				if( k==1 || i == rows || k==(2*i-1)) {
					System.out.print("*");
				}
				else {  
					System.out.print(" ");
				}
			}
			// iii) go to next line
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {

//		4. create object for class
		InvertedVPattern invertedVPattern = new InvertedVPattern();
		
//		5. call the pattern method 
		invertedVPattern.pattern();
	}
}